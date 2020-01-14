package fr.polytech.tours.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location  {

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
