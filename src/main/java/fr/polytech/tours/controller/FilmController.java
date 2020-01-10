package fr.polytech.tours.controller;

import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Film;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.view.MainWindow;

import javax.swing.*;

public class FilmController {

    private MainWindow view;

    public FilmController() {
        SwingUtilities.invokeLater(() -> view = new MainWindow());
    }

    public void selectFilm(Film film) {

    }

    public void selectScene(Scene scene) {

    }

    public void selectClap(Clap clap) {

    }
}
