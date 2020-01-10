package fr.polytech.tours.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JLabel appTitle;
    private JLabel movieTitle;
    private JPanel panelTitle;

    public MainWindow () {

        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        appTitle = new JLabel("FILMATOR");
        movieTitle = new JLabel("Ninja hilter contre les dinosaures de l'espace");

        panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));
        panelTitle.add(appTitle);
        panelTitle.add(movieTitle);
        this.add(panelTitle, BorderLayout.NORTH);

        ElementWindow scene = new ElementWindow();
        ElementWindow setup = new ElementWindow();
        ElementWindow clap = new ElementWindow();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3, 10, 0));

        panel.add(scene);
        panel.add(setup);
        panel.add(clap);

        this.add(panel, BorderLayout.CENTER);
    }
}
