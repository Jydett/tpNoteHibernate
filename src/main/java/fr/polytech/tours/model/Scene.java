package fr.polytech.tours.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Scene implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ManyToOne
    private Film film;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scene")
    private List<Setup> setups;
}
