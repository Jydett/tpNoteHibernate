package fr.polytech.tours.view;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ElementWindow<E> extends JPanel {

    private final InformationWindow<E> info;
    private JScrollPane scrollPaneItem;
    private JList<E> listItem;
    private DefaultListModel<E> listModel;

    public ElementWindow(BiConsumer<InformationWindow<E>, E> displayer) {
        this.setLayout(new BorderLayout());
        this.info = new InformationWindow<>(displayer);

        listModel = new DefaultListModel<>();

        listItem = new JList<>(listModel);
        listItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPaneItem = new JScrollPane(listItem);

        this.add(info, BorderLayout.SOUTH);
        this.add(scrollPaneItem, BorderLayout.CENTER);
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

    public void deleteElements(){
        listModel.removeAllElements();
    }

    public void addElements(Collection<E> collection) {
        for (E e : collection) {
            listModel.addElement(e);
        }
    }

    public void addSelectionListener(Consumer<E> listener) {
        listItem.addListSelectionListener(e -> {
            if (! e.getValueIsAdjusting()){
                listener.accept(listModel.getElementAt(e.getFirstIndex()));
            }
        });
    }

}
