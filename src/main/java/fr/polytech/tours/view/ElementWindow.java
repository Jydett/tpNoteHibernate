package fr.polytech.tours.view;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class ElementWindow<E> extends JPanel {

    private JScrollPane scrollPaneItem;
    private JList<E> listItem;
    private DefaultListModel<E> listModel;


    public ElementWindow() {
        this.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();

        listItem = new JList<>(listModel);
        listItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPaneItem = new JScrollPane(listItem);

        this.add(scrollPaneItem, BorderLayout.CENTER);
    }

    public void addElement(int index, E element) {
        listModel.add(index, element);
    }

    public void deleteElement(int index) {
        listModel.remove(index);
    }

    public void addElements(Collection<E> collection) {
        for (E e : collection) {
            listModel.addElement(e);
        }
    }

}
