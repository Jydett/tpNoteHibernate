package fr.polytech.tours.view;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class InformationWindow<E> extends JPanel {

    private JLabel labelSelect;
    private JLabel itemSelect;
    private BiConsumer<InformationWindow<E>, E> displayer;

    public void ConstructInfo(BiConsumer<InformationWindow<E>, E> displayer) {
        this.displayer = displayer;
        this.setLayout(new FlowLayout());

        labelSelect = new JLabel("Sélectionné : ");
        itemSelect = new JLabel();

        this.add(labelSelect);
        this.add(itemSelect);
    }

    public JLabel getItemSelect() {
        return itemSelect;
    }

    public void update(E newSelection) {
        displayer.accept(this, newSelection);
    }
}
