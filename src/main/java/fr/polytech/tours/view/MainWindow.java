package fr.polytech.tours.view;

import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.Setup;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JLabel appTitle;
    private JLabel movieTitle;
    private JPanel panelTitle;

    private ElementWindow<Scene> scene;
    private ElementWindow<Setup> setup;
    private ElementWindow<Clap> clap;

    private InformationWindow sceneInfo;
    private InformationWindow setupInfo;
    private InformationWindow clapInfo;

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

        scene = new ElementWindow<>();
        setup = new ElementWindow<>();
        clap = new ElementWindow<>();
        sceneInfo = new InformationWindow();
        setupInfo = new InformationWindow();
        clapInfo = new InformationWindow();

        scene.add(sceneInfo);
        setup.add(setupInfo);
        clap.add(clapInfo);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3, 10, 0));

        panel.add(scene);
        panel.add(setup);
        panel.add(clap);

        this.add(panel, BorderLayout.CENTER);
    }

    public ElementWindow getScene() {
        return scene;
    }

    public ElementWindow getSetup() {
        return setup;
    }

    public ElementWindow getClap() {
        return clap;
    }
}
