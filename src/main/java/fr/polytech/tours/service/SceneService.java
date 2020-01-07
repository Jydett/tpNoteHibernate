package fr.polytech.tours.service;

import fr.polytech.tours.dao.IDao;
import fr.polytech.tours.model.Clap;
import fr.polytech.tours.model.Scene;
import fr.polytech.tours.model.scene.ExteriorScene;
import fr.polytech.tours.model.scene.InteriorScene;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class SceneService {

    private IDao<Integer, Scene> sceneDao;

    public long getGetTotalTime(Scene scene) {
        return scene.getSetups().stream().flatMap(s -> s.getClaps().stream()).map(Clap::getTimeInMs).reduce(0L, Long::sum);
    }

    public int getLocationCode(Scene scene) throws IllegalArgumentException {
        if (scene instanceof InteriorScene) {
            InteriorScene interiorScene = (InteriorScene) scene;
            return interiorScene.getTheaterCode();
        } else if (scene instanceof ExteriorScene) {
            ExteriorScene exteriorScene = (ExteriorScene) scene;
            return exteriorScene.getLocation().getId();
        }
        throw new IllegalArgumentException("Unknown scene type !");
    }

    public Scene get(Integer id) {
        return sceneDao.get(id);
    }

    public List<Scene> getAll() {
        //TODO
        return Collections.emptyList();
    }
}
