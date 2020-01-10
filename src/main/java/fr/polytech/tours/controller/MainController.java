package fr.polytech.tours.controller;

import fr.polytech.tours.dao.DaoConfiguration;
import fr.polytech.tours.dao.DaoRegistery;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.scene.InteriorScene;

public class MainController {

    public static void main(String[] args) {
        DaoConfiguration daoConfiguration = new DaoConfiguration();
        FilmController filmController = new FilmController();
    }
}
