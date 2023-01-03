package com.lina.animals;

import lombok.Value;

@Value
public class UpdateAnimal {

    String name;
    String binomialName;
    String description;
    String conservationStatus;
}
