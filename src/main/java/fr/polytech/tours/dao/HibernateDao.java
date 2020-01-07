package fr.polytech.tours.dao;

import fr.polytech.tours.model.Versionable;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import java.io.Serializable;

public class HibernateDao<Id extends Serializable, V extends Versionable<Id>> implements IDao<Id, V> {

    private Session hibernateSession;
    private Class<V> persistentClass;

    public HibernateDao(Session session, Class<V> persistentClass) {
        this.hibernateSession = session;
        this.persistentClass = persistentClass;
    }

    public void save(V o) {
        hibernateSession.saveOrUpdate(o);
    }

    public V get(Id id) {
        V res = hibernateSession.get(this.persistentClass, id);
        if (res == null) {
            throw new ObjectNotFoundException(persistentClass, id.toString());
        }
        return res;
    }

    @Override
    public Class<V> getPersistanceClazz() {
        return persistentClass;
    }
}
