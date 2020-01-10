package fr.polytech.tours.model.scene;

import fr.polytech.tours.model.Scene;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
public class InteriorScene extends Scene {
    private int theaterCode;

    @Override
    public String toString() {
        return super.toString() + ", interior";
    }
}
