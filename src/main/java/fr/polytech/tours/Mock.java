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
        film.setName("Métal Hurlant");

        //scènes
        Scene sceneIntro = InteriorScene.id(1);
        sceneIntro.setFilm(film);
        sceneIntro.setDescription("Scène d'introduction");

        Scene sceneInvaVil = InteriorScene.id(2);
        sceneInvaVil.setFilm(film);
        sceneInvaVil.setDescription("Scène de l'invasion du village");

        Scene sceneMortP = InteriorScene.id(3);
        sceneMortP.setFilm(film);
        sceneMortP.setDescription("Scène de la mort des parents");

        Scene sceneCombTyl = InteriorScene.id(4);
        sceneCombTyl.setFilm(film);
        sceneCombTyl.setDescription("Scène du combat contre Tyler");

        //setups
        Setup setupIntroPl = new Setup();
        setupIntroPl.setId(1);
        setupIntroPl.setDescription("Angle en plongé");
        setupIntroPl.setScene(sceneIntro);

        Setup setupIntroCP = new Setup();
        setupIntroCP.setId(2);
        setupIntroCP.setDescription("Angle en contre plongé");
        setupIntroCP.setScene(sceneIntro);

        Setup setupIntroSC = new Setup();
        setupIntroSC.setId(3);
        setupIntroSC.setDescription("Angle en superposition cadré");
        setupIntroSC.setScene(sceneIntro);
        sceneIntro.setSetups(Arrays.asList(setupIntroCP, setupIntroSC, setupIntroPl));

        Setup setupInvaCP = new Setup();
        setupInvaCP.setId(4);
        setupInvaCP.setDescription("Angle en contre plongé");
        setupInvaCP.setScene(sceneInvaVil);

        Setup setupInvaPe = new Setup();
        setupInvaPe.setId(5);
        setupInvaPe.setDescription("Angle en perspective");
        setupInvaPe.setScene(sceneInvaVil);
        sceneInvaVil.setSetups(Arrays.asList(setupInvaPe, setupInvaCP));


        Clap clapIntroCP = new Clap();
        clapIntroCP.setId(1);
        clapIntroCP.setRollFilmId(23);
        clapIntroCP.setTimeInMs(12569);
        clapIntroCP.setSetup(setupIntroCP);

        Clap clapIntroCPb = new Clap();
        clapIntroCPb.setId(2);
        clapIntroCPb.setRollFilmId(23);
        clapIntroCPb.setTimeInMs(6565);
        clapIntroCPb.setSetup(setupIntroCP);
        setupIntroCP.setClaps(Arrays.asList(clapIntroCP, clapIntroCPb));

        Clap clapIntroPL = new Clap();
        clapIntroPL.setId(3);
        clapIntroPL.setRollFilmId(26);
        clapIntroPL.setTimeInMs(12944);
        clapIntroPL.setSetup(setupIntroPl);
        setupIntroPl.setClaps(Arrays.asList(clapIntroPL));

        Clap clapIntroSC = new Clap();
        clapIntroSC.setId(4);
        clapIntroSC.setRollFilmId(28);
        clapIntroSC.setTimeInMs(96532);
        clapIntroSC.setSetup(setupIntroSC);

        Clap clapIntroSCb = new Clap();
        clapIntroSCb.setId(5);
        clapIntroSCb.setRollFilmId(28);
        clapIntroSCb.setTimeInMs(12367);
        clapIntroSCb.setSetup(setupIntroSC);

        Clap clapIntroSCc = new Clap();
        clapIntroSCc.setId(6);
        clapIntroSCc.setRollFilmId(28);
        clapIntroSCc.setTimeInMs(45961);
        clapIntroSCc.setSetup(setupIntroSC);
        setupIntroSC.setClaps(Arrays.asList(clapIntroSC, clapIntroSCb, clapIntroSCc));

        DaoRegistery.getInstance().get(Clap.class).save(clapIntroCP);
        DaoRegistery.getInstance().get(Clap.class).save(clapIntroCPb);
        DaoRegistery.getInstance().get(Clap.class).save(clapIntroPL);
        DaoRegistery.getInstance().get(Clap.class).save(clapIntroSC);
        DaoRegistery.getInstance().get(Clap.class).save(clapIntroSCb);
        DaoRegistery.getInstance().get(Clap.class).save(clapIntroSCc);

        DaoRegistery.getInstance().get(Setup.class).save(setupIntroPl);
        DaoRegistery.getInstance().get(Setup.class).save(setupInvaPe);
        DaoRegistery.getInstance().get(Setup.class).save(setupInvaCP);
        DaoRegistery.getInstance().get(Setup.class).save(setupIntroSC);
        DaoRegistery.getInstance().get(Setup.class).save(setupIntroCP);

        DaoRegistery.getInstance().get(Scene.class).save(sceneMortP);
        DaoRegistery.getInstance().get(Scene.class).save(sceneInvaVil);
        DaoRegistery.getInstance().get(Scene.class).save(sceneIntro);

        film.setScenes(Arrays.asList(sceneIntro, sceneMortP, sceneInvaVil));
        DaoRegistery.getInstance().get(Film.class).save(film);
    }
}
