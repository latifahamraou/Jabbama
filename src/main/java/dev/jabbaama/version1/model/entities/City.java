package dev.jabbaama.version1.model.entities;

import jakarta.persistence.Embeddable;

@Embeddable

public class City {

    private String country;
    private String city;
}
