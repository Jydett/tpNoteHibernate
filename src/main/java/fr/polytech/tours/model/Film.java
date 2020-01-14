package fr.polytech.tours.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Film implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    @Setter//FIXME to remove (test)
    private List<Scene> scenes;

    private String name;

    @Override//TODO faire dans un rendrerer plutot
    public String toString() {
        return name;
    }
}
