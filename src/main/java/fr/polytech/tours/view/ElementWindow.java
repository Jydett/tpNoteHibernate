package fr.polytech.tours.view;

import javax.swing.*;
import java.awt.*;

public class ElementWindow extends JPanel {

    private JScrollPane scrollPaneItem;
    private JList<String> listItem;

    public ElementWindow(){

        this.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();

        listModel.addElement("Setup 1");
        listModel.addElement("Setup 2");
        listModel.addElement("Setup 3");

        listItem = new JList<>(listModel);
        listItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPaneItem = new JScrollPane(listItem);


        this.add(scrollPaneItem, BorderLayout.CENTER);
    }

}
