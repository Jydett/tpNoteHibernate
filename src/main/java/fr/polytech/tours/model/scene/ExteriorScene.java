package fr.polytech.tours.model.scene;

import fr.polytech.tours.model.Location;
import fr.polytech.tours.model.Scene;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class ExteriorScene extends Scene {
    //TODO
    @ManyToOne
    private Location location;
}
