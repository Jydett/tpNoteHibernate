package fr.polytech.tours.dao;

import fr.polytech.tours.model.Versionable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DaoRegistery {

    public Map<String, IDao> registery;

    private static DaoRegistery INSTANCE;

    public static DaoRegistery getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DaoRegistery();
        }
        return INSTANCE;
    }

    public DaoRegistery() {
        registery = new HashMap<>();
    }

    public <Id extends Serializable, V extends Versionable<Id>> void register(IDao<Id, V> dao) {
        registery.put(dao.getPersistanceClazz().getName(), dao);
    }

    public <Id extends Serializable, V extends Versionable<Id>> IDao<Id, V> get(Class<V> clazz) {
        return registery.get(clazz.getName());
    }
}
