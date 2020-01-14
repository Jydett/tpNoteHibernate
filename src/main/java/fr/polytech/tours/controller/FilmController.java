package fr.polytech.tours.controller;

import fr.polytech.tours.dao.DaoRegistery;
import fr.polytech.tours.dao.IDao;
import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Film;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.Setup;
import fr.polytech.tours.model.scene.InteriorScene;
import fr.polytech.tours.service.SceneService;
import fr.polytech.tours.view.MainWindow;

import javax.swing.SwingUtilities;
import java.util.Arrays;

public class FilmController {

    private MainWindow view;
    private SceneService sceneService;

    public FilmController() {
        sceneService = SceneService.INSTANCE;
        SwingUtilities.invokeLater(() -> {
            view = new MainWindow(this);
            IDao<Integer, Film> filmDao = DaoRegistery.getInstance().get(Film.class);
            if (filmDao.count() < 1) {
                //TODO si pas de film alors popup + creer
            } else {
                Film film = filmDao.get(1);
                selectFilm(film);
            }
        });
    }

    public void selectFilm(Film film) {
        view.getScene().deleteElements();
        view.getSetup().deleteElements();
        view.getClap().deleteElements();
        view.getScene().addElements(film.getScenes());
    }

    public void selectScene(Scene scene) {
        view.getSetup().deleteElements();
        view.getClap().deleteElements();
        view.getScene().getInfo().removeAll();
        view.getSetup().addElements(scene.getSetups());
        view.getScene().getInfo().update(scene);
    }

    public void selectSetup(Setup setup) {
        view.getClap().deleteElements();
        view.getSetup().getInfo().removeAll();
        view.getClap().addElements(setup.getClaps());
        view.getSetup().getInfo().update(setup);
    }

    public void selectClap(Clap clap) {
        view.getClap().getInfo().removeAll();
        view.getClap().getInfo().update(clap);
    }

    public long getTotalTime(Scene scene) {
        return sceneService.getTotalTime(scene);
    }

    public int getLocationCode(Scene scene) {
        return sceneService.getLocationCode(scene);
    }
}
