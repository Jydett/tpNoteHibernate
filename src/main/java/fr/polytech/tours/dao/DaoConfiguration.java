package fr.polytech.tours.dao;

import fr.polytech.tours.model.*;
import fr.polytech.tours.model.scene.ExteriorScene;
import fr.polytech.tours.model.scene.InteriorScene;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DaoConfiguration {

    private DaoRegistery daoRegistery;
    private Session hibernateSession;

    public DaoConfiguration() {
        daoRegistery = DaoRegistery.getInstance();
        createSession();
        registerDaos();
    }

    private void createSession() {
        hibernateSession = new Configuration().configure().buildSessionFactory().openSession();
    }

    private void registerDaos() {
        daoRegistery.register(new HibernateDao<>(hibernateSession, Clap.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, ExteriorScene.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, InteriorScene.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Location.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Scene.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Setup.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Film.class));
    }
}
