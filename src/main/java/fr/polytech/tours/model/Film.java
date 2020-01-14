package fr.polytech.tours.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Film implements Versionable<Integer> {
    @Id
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "film")
    @Setter//FIXME to remove (test)
    private List<Scene> scenes;

    private String name;

    public static Film id(int i) {
        Film film = new Film();
        film.id = i;
        return film;
    }

    @Override//TODO faire dans un rendrerer plutot
    public String toString() {
        return name;
    }
}
