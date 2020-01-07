package fr.polytech.tours.dao;

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
        EntityManager entityManager = Persistence.createEntityManagerFactory("c").createEntityManager();
        hibernateSession = entityManager.unwrap(Session.class);
    }

    private void registerDaos() {

    }
}
