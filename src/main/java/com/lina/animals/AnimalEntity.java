package com.lina.animals;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalEntity {

    String id;
    String name;
    String binomialName;
    String description;
    String conservationStatus;

}
