package fr.polytech.tours.controller;

import fr.polytech.tours.dao.DaoConfiguration;

public class MainController {

    public static void main(String[] args) {
        DaoConfiguration daoConfiguration = new DaoConfiguration();
        FilmController filmController = new FilmController();
    }
}
