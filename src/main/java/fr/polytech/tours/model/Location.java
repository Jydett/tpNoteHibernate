package fr.polytech.tours.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
@Data
@Entity
public class Location implements Versionable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer locId;

    private String country;

    private String city;

    private Integer postCode;

    private String street;

    @Override
    public String toString() {
        return "in " + country + ", " + city + ", " + postCode + ", " + street;
    }
}
