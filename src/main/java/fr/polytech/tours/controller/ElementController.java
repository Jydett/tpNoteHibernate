package fr.polytech.tours.controller;

import fr.polytech.tours.dao.DaoRegistery;
import fr.polytech.tours.dao.IDao;
import fr.polytech.tours.model.Versionable;
import fr.polytech.tours.view.ElementWindow;
import fr.polytech.tours.view.InformationWindow;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

public abstract class ElementController<Id extends Serializable, E extends Versionable<Id>, C extends Versionable<?>> {
    @Getter
    public ElementWindow<E> view;
    public ElementController<?, C, ?> childController;
    public IDao<Id, E> dao;

    public ElementController(Class<E> clazz, ElementController<?, C, ?> childController) {
        dao = DaoRegistery.getInstance().get(clazz);
        if (dao == null) {
            throw new IllegalArgumentException("No DAO for the class " + clazz.getSimpleName());
        }
        this.view = new ElementWindow<>(this, this::displayInformation);
        this.childController = childController;
    }

    public abstract List<C> getChildren(E element);

    public void displayInformation(InformationWindow<E> info, E element) {

    }

    /**
     * Supprime l'élément passé en paramètre
     * @param toDelete : à supprimer
     * @return true si la suppréssion a réussi
     */
    public boolean delete(E toDelete) {
        try {
            dao.delete(toDelete);
            if (childController != null) {
                childController.parentDeleted();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void select(E element) {
        view.getInfo().updateInfo(element);
        if (childController != null) {
            childController.removeAll();
            childController.display(getChildren(element));
        }
    }

    private void display(List<E> children) {
        view.deleteElements();
        if (children != null) {
            view.addElements(children);
        }
    }

    private void removeAll() {
        view.deleteElements();
        view.getInfo().removeAll();
        if (childController != null) {
            childController.removeAll();
        }
    }

    public void parentDeleted() {
        this.removeAll();
        if (childController != null) {
            childController.parentDeleted();
        }
    }
}
