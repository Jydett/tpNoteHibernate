package fr.polytech.tours.controller;

import fr.polytech.tours.Mock;
import fr.polytech.tours.dao.DaoRegistery;
import fr.polytech.tours.dao.IDao;
import fr.polytech.tours.model.*;
import fr.polytech.tours.service.SceneService;
import fr.polytech.tours.view.InformationWindow;
import fr.polytech.tours.view.MainWindow;

import javax.swing.SwingUtilities;
import java.util.List;

public class FilmController {

    private MainWindow view;
    private SceneService sceneService;
    private ElementController<Integer, Film, Scene> filmController;

    public FilmController() {
        sceneService = SceneService.INSTANCE;
        SwingUtilities.invokeLater(() -> {
            view = new MainWindow(this);
            init();
            IDao<Integer, Film> filmDao = DaoRegistery.getInstance().get(Film.class);
            long count = filmDao.count();
            System.out.println("Il y a " + count + " films");
            if (count < 1) {
                //TODO si pas de film alors popup + creer
                Mock.fillBase();
            }
            Film film = filmDao.get(1);
            filmController.getView().addElement(0, film);
        });
    }

    private void init() {
        ElementController clapElement = new ElementController<Integer, Clap, Versionable<?>>(Clap.class, null) {
            @Override
            public List<Versionable<?>> getChildren(Clap element) {
                return null;
            }

            @Override
            public void displayInformation(InformationWindow<Clap> info, Clap element) {
                info.updateField("id", Integer.toString(element.getId()));
                info.updateField("id de bobine", Integer.toString(element.getRollFilmId()));
                info.updateField("temps (ms)", Long.toString(element.getTimeInMs()));
            }
        };
        view.addElementColumn(clapElement.getView());

        ElementController setupElement = new ElementController<Integer, Setup, Clap>(Setup.class, clapElement) {
            @Override
            public List<Clap> getChildren(Setup element) {
                return element.getClaps();
            }

            @Override
            public void displayInformation(InformationWindow<Setup> info, Setup element) {
                info.updateField("id", Integer.toString(element.getId()));
                info.updateField("description", element.getDescription());
            }
        };
        view.addElementColumn(setupElement.getView());

        ElementController sceneElement = new ElementController<Integer, Scene, Setup>(Scene.class, setupElement) {
            @Override
            public List<Setup> getChildren(Scene element) {
                return element.getSetups();
            }

            @Override
            public void displayInformation(InformationWindow<Scene> info, Scene element) {
                info.updateField("id", Integer.toString(element.getId()));
                info.updateField("description", element.getDescription());
                info.button("Calculer le temps total ", () -> MainWindow.popup(getTotalTime(getView().getSelected())));
                info.button("Avoir le code de la location de tournage ", () -> MainWindow.popup(getLocationCode(getView().getSelected())));
            }
        };
        view.addElementColumn(sceneElement.getView());

        filmController = new ElementController<Integer, Film, Scene>(Film.class, sceneElement) {
            @Override
            public List<Scene> getChildren(Film element) {
                return element.getScenes();
            }

            @Override
            public void displayInformation(InformationWindow<Film> info, Film element) {
                info.updateField("id", Integer.toString(element.getId()));
                info.updateField("nom", element.getName());
            }
        };
        view.addElementColumn(filmController.getView());
    }

    public long getTotalTime(Scene scene) {
        return sceneService.getTotalTime(scene);
    }

    public int getLocationCode(Scene scene) {
        return sceneService.getLocationCode(scene);
    }
}
