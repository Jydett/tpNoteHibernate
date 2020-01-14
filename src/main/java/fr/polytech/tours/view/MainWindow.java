package fr.polytech.tours.view;

import fr.polytech.tours.controller.FilmController;
import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.Setup;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel panelTitle;
    private JPanel columnsPanel;

    private FilmController controller;

    public MainWindow(FilmController controller) {
        this.controller = controller;

        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1200, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));
        this.add(panelTitle, BorderLayout.NORTH);

        columnsPanel = new JPanel();
        columnsPanel.setLayout(new GridLayout(1,3, 10, 0));
        this.add(columnsPanel, BorderLayout.CENTER);
    }

    public static void popup(Object message) {
        JOptionPane.showMessageDialog(null, message, "Resultat", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addElementColumn(ElementWindow elementWindow) {
        columnsPanel.add(elementWindow, 0);
    }
}
