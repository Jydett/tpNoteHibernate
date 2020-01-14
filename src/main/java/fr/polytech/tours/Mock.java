package fr.polytech.tours;

import fr.polytech.tours.dao.DaoRegistery;
import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Film;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.Setup;
import fr.polytech.tours.model.scene.InteriorScene;

import java.util.Arrays;

public class Mock {

    public static void fillBase() {
        Film film = Film.id(1);
        film.setName("Les nija");

        Scene scene = InteriorScene.id(1);
        scene.setFilm(film);
        scene.setDescription("Scène de l'apparition du héro");

        Setup setup = new Setup();
//        setup.setId(1);
        setup.setDescription("Angle en plongé");
        setup.setScene(scene);
        scene.setSetups(Arrays.asList(setup));

        Clap clap2 = new Clap();
//        clap.setId(1);
        clap2.setRollFilmId(253);
        clap2.setTimeInMs(1);
        clap2.setSetup(setup);

        Clap clap = new Clap();
//        clap.setId(1);
        clap.setRollFilmId(23);
        clap.setTimeInMs(12569);
        clap.setSetup(setup);
        setup.setClaps(Arrays.asList(clap, clap2));

        DaoRegistery.getInstance().get(Setup.class).save(setup);
        DaoRegistery.getInstance().get(Clap.class).save(clap);
        DaoRegistery.getInstance().get(Clap.class).save(clap2);
        DaoRegistery.getInstance().get(Scene.class).save(scene);
        film.setScenes(Arrays.asList(scene));
        DaoRegistery.getInstance().get(Film.class).save(film);
    }
}
