package fr.polytech.tours.view;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class InformationWindow<E> extends JPanel {

    private JLabel labelSelect;
    private JLabel itemSelect;
    private Map<String, JLabel> fields;

    public InformationWindow() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        fields = new HashMap<>();

        labelSelect = new JLabel("Sélectionné : ");
        itemSelect = new JLabel();

        this.add(labelSelect);
        this.add(itemSelect);
    }

    public JLabel getItemSelect() {
        return itemSelect;
    }

    public abstract void update(E newSelection);

    public void updateField(String id, String value) {
        JLabel field;
        if (! fields.containsKey(id)) {
            field = new JLabel();
            this.add(field);
        } else {
            field = fields.get(id);
        }
        field.setText(id + " : " + value);
    }

    public void removeAll() {
        fields.clear();
        super.removeAll();
    }

    public void button(String title, Runnable runnable) {
        JButton jButton = new JButton(title);
        jButton.addActionListener(l -> runnable.run());
        this.add(jButton);
    }

    public void updateInfo(E element) {
        removeAll();
        update(element);
        repaint();
    }
}
