package fr.polytech.tours.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Clap implements Versionable<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int rollFilmId;

    private long timeInMs;

    @ManyToOne
    private Setup setup;
}
