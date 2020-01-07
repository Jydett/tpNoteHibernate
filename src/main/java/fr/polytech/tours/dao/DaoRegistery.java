package fr.polytech.tours.dao;

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

    public <T> void register(Class<T> clazz, IDao<T> dao) {
        registery.put(clazz.getName(), dao);
    }

    public <T> IDao<T> get(Class<T> clazz) {
        return registery.get(clazz.getName());
    }
}
