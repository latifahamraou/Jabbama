package dev.jabbaama.version1.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable

public class Adress {

    private String rue;

    @Embedded
    private City city;
}
