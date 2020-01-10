package fr.polytech.tours.view;

import javax.swing.*;
import java.awt.*;

public class ElementWindow<E> extends JPanel {

    private JScrollPane scrollPaneItem;
    private JList<E> listItem;

    public ElementWindow() {
        this.setLayout(new BorderLayout());

        DefaultListModel<E> listModel = new DefaultListModel<>();

        listItem = new JList<>(listModel);
        listItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPaneItem = new JScrollPane(listItem);

        this.add(scrollPaneItem, BorderLayout.CENTER);
    }

}
