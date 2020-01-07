package fr.polytech.tours.dao;

import fr.polytech.tours.model.*;
import fr.polytech.tours.model.scene.ExteriorScene;
import fr.polytech.tours.model.scene.InteriorScene;
import org.hibernate.Session;

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
        EntityManager entityManager = Persistence.createEntityManagerFactory("test").createEntityManager();
        hibernateSession = entityManager.unwrap(Session.class);
    }

    private void registerDaos() {
        daoRegistery.register(new HibernateDao<>(hibernateSession, Clap.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, ExteriorScene.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, InteriorScene.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Location.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Scene.class));
        daoRegistery.register(new HibernateDao<>(hibernateSession, Setup.class));
    }
}
