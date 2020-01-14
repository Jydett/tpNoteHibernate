package fr.polytech.tours.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
public class Clap implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    private int rollFilmId;

    @Setter
    private long timeInMs;

    @ManyToOne
    @Setter
    private Setup setup;

    @Override
    public String toString() {
        return "id = " + id + "roll film id  = " + rollFilmId + ", time in ms : " + timeInMs;
    }
}
