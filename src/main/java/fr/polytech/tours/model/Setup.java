package fr.polytech.tours.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Setup implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Integer id;

    @Setter
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "setup")
    @Setter
    private List<Clap> claps;

    @ManyToOne
    @Setter
    private Scene scene;

    @Override
    public String toString() {
        return "id = " + id + ", description : " + description;
    }
}
