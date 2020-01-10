package fr.polytech.tours.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Setup implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "setup")
    private List<Clap> claps;

    @ManyToOne
    private Scene scene;

    @Override
    public String toString() {
        return "id = " + id + ", description : " + description;
    }
}
