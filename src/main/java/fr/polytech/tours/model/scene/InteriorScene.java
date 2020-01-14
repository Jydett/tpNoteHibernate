package fr.polytech.tours.model.scene;

import fr.polytech.tours.model.Scene;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
public class InteriorScene extends Scene {
    private int theaterCode;

    public static Scene id(int i) {
        InteriorScene interiorScene = new InteriorScene();
        interiorScene.id = i;
        return interiorScene;
    }

    @Override
    public String toString() {
        return super.toString() + ", interior, theaterCode:" + theaterCode;
    }
}
