package fr.polytech.tours.model.scene;

import fr.polytech.tours.model.Location;
import fr.polytech.tours.model.Scene;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
public class ExteriorScene extends Scene {

    @Embedded
    private Location location;

    @Override
    public String toString() {
        return super.toString() + ", exterior, location:" + location.toString();
    }
}
