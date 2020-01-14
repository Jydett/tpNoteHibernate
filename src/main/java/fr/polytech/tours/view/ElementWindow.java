package fr.polytech.tours.view;

import fr.polytech.tours.controller.ElementController;
import fr.polytech.tours.model.Versionable;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ElementWindow<E extends Versionable<?>> extends JPanel {

    private final InformationWindow<E> info;
    private JScrollPane scrollPaneItem;
    private JList<E> listItem;
    private DefaultListModel<E> listModel;
    private JButton addBtn;
    private JButton delBtn;
    private ElementController<?, E, ?> controller;

    public ElementWindow(ElementController<?, E, ?> controller, BiConsumer<InformationWindow<E>, E> displayUpdate) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        this.info = new InformationWindow<E>() {
            @Override
            public void update(E newSelection) {
                displayUpdate.accept(info, newSelection);
            }
        };

        listModel = new DefaultListModel<>();

        listItem = new JList<>(listModel);
        listItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPaneItem = new JScrollPane(listItem);

        this.add(info, BorderLayout.SOUTH);
        this.add(scrollPaneItem, BorderLayout.CENTER);
        delBtn = new JButton("Supprimer");
        addBtn = new JButton("Nouveau");
        JPanel btnPanel = new JPanel();
        listItem.addListSelectionListener(e -> {
            if (! e.getValueIsAdjusting()) {
                if (listItem.getSelectedValue() == null) {
                    delBtn.setEnabled(false);
                } else {
                    controller.select(listItem.getSelectedValue());
                    delBtn.setEnabled(true);
                }
            }
        });
        delBtn.addActionListener(l -> {
            int selectedIndex = listItem.getSelectedIndex();
            E selectedValue = listItem.getSelectedValue();
            if (controller.delete(selectedValue)) {
                listModel.remove(selectedIndex);
            }
        });
        delBtn.setEnabled(false);
        btnPanel.add(addBtn);
        btnPanel.add(delBtn);
        this.add(btnPanel, BorderLayout.NORTH);
    }

    public void addElement(int index, E element){
        listModel.add(index, element);
    }

    public InformationWindow<E> getInfo() {
        return info;
    }

    public void deleteElement(int index) {
        listModel.remove(index);
    }

    public void deleteElements() {
        listModel.removeAllElements();
    }

    public void addElements(Collection<E> collection) {
        if (collection == null) return;
        for (E e : collection) {
            listModel.addElement(e);
        }
    }
}
