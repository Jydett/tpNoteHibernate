package fr.polytech.tours.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Film implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Scene> scenes;
}
