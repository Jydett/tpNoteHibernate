package fr.polytech.tours.view;

import fr.polytech.tours.controller.FilmController;
import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.Setup;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JLabel appTitle;
    private JLabel movieTitle;
    private JPanel panelTitle;

    @Getter
    private ElementWindow<Scene> scene;
    @Getter
    private ElementWindow<Setup> setup;
    @Getter
    private ElementWindow<Clap> clap;
    private FilmController controller;

    public MainWindow(FilmController controller) {
        this.controller = controller;

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

        scene = new ElementWindow<>((win, scene1) -> {
            if (scene1 == null) {
                win.removeAll();
            } else {
                win.updateField("sceneId", "Id de la scene: " + scene1.getId());
            }
        });
        scene.addSelectionListener(controller::selectScene);
        setup = new ElementWindow<>((win, setup1) -> {
            if (setup1 == null) {
                win.removeAll();
            } else {
                win.updateField("setupId", "Id du setup: " + setup1.getId());
            }
        });
        setup.addSelectionListener(controller::selectSetup);
        clap = new ElementWindow<>((win, clap1) -> {
            if (clap1 == null) {
                win.removeAll();
            } else {
                win.updateField("clapId", "Id du clap: " + clap1.getId());
            }
        });
        clap.addSelectionListener(controller::selectClap);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3, 10, 0));

        panel.add(scene);
        panel.add(setup);
        panel.add(clap);

        this.add(panel, BorderLayout.CENTER);
    }
}
