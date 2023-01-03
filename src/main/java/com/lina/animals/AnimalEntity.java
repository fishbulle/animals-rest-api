package com.lina.animals;

import lombok.*;

@Data
@AllArgsConstructor
public class AnimalEntity {

    private String id;
    private String name;
    private String binomialName;
    private String description;
    private String conservationStatus;

}
