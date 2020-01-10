package fr.polytech.tours.view;

import javax.swing.*;
import java.awt.*;

public class InformationWindow extends JPanel {

    private JLabel labelSelect;
    private JLabel itemSelect;

    public void ConstructInfo(){
        this.setLayout(new FlowLayout());

        labelSelect = new JLabel("Sélectionné : ");
        itemSelect = new JLabel();

        this.add(labelSelect);
        this.add(itemSelect);
    }

    public void setItemSelect(String itemName) {
        itemSelect.setText(itemName);
    }

    public JLabel getItemSelect() {
        return itemSelect;
    }
}
