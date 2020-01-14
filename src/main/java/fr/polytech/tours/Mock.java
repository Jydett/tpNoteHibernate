package fr.polytech.tours;

import fr.polytech.tours.dao.DaoRegistery;
import fr.polytech.tours.model.Film;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.scene.InteriorScene;

import java.util.Arrays;

public class Mock {

    public static void fillBase() {
        Film film = Film.id(1);
        Scene scene = InteriorScene.id(1);
        DaoRegistery.getInstance().get(Scene.class).save(scene);
        film.setScenes(Arrays.asList(scene));
        DaoRegistery.getInstance().get(Film.class).save(film);
    }
}
