package fr.polytech.tours.dao;

import fr.polytech.tours.model.Versionable;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

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

    public long count() {
        return (Long) hibernateSession.createQuery("select count(*) from " + persistentClass.getSimpleName()).uniqueResult();
    }

    @Override
    public void delete(V element) {
        Transaction transaction = hibernateSession.beginTransaction();
        hibernateSession.remove(element);
        transaction.commit();
    }

    @Override
    public Class<V> getPersistanceClazz() {
        return persistentClass;
    }
}
