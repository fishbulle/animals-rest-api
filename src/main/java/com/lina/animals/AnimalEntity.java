package com.lina.animals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Animal")
@Table(name = "Animals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimalEntity {

    @Id
    @SequenceGenerator(
            name = "animal_sequence",
            sequenceName = "animal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "animal_sequence"
    )
    private String id;
    private String name;
    private String binomialName;
    private String description;
    private String conservationStatus;

}
