package fr.polytech.tours.dao;

import fr.polytech.tours.model.Versionable;

import java.io.Serializable;

public interface IDao<Id extends Serializable, T extends Versionable<Id>> {
    Class<T> getPersistanceClazz();

    T get(Id id);

    void save(T toSave);

    long count();

    void delete(T element);
}
