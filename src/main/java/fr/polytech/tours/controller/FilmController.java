package fr.polytech.tours.controller;

import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Film;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.service.SceneService;
import fr.polytech.tours.view.MainWindow;

import javax.swing.SwingUtilities;

public class FilmController {

    private MainWindow view;
    private SceneService sceneService;

    public FilmController() {
        SwingUtilities.invokeLater(() -> view = new MainWindow());
        sceneService = SceneService.INSTANCE;
    }

    public void selectFilm(Film film) {
        view.getScene().addElements(film.getScenes());
    }

    public void selectScene(Scene scene) {
        view.getSetup().addElements(scene.getSetups());
        view.getScene().getInfo().update(scene);
    }

    public void selectClap(Clap clap) {
        view.getClap().getInfo().update(clap);
    }

    public long getTotalTime(Scene scene) {
        return sceneService.getTotalTime(scene);
    }

    public int getLocationCode(Scene scene) {
        return sceneService.getLocationCode(scene);
    }
}
