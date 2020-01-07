package fr.polytech.tours.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

public class HibernateDao<T> implements IDao<T> {

    private Session hibernateSession;
    private Class<T> persistentClass;

    public HibernateDao(Session session) {
        this.hibernateSession = session;
    }

    public void save(T o) {
        hibernateSession.saveOrUpdate(o);
    }

    public T read(Integer id) {
        T res = hibernateSession.get(this.persistentClass, id);
        if (res == null) {
            throw new ObjectNotFoundException(persistentClass, id.toString());
        }
        return res;
    }
}
