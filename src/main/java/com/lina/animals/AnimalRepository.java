package com.lina.animals;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Stream;

@Component
public class AnimalRepository {

    public Stream<AnimalEntity> all() {
        return Stream.of(
                new AnimalEntity(UUID.randomUUID().toString(), "cat", "felis catus", "", ""),
                new AnimalEntity(UUID.randomUUID().toString(), "dog", "canis lupus familiaris", "", "")
        );
    }

    public AnimalEntity save(AnimalEntity animalEntity) {
        return animalEntity;
    }

    public AnimalEntity get(String id) {
        return new AnimalEntity(
                id,
                "Zebra",
                "X",
                "",
                ""
        );
    }

    public void delete(AnimalEntity animalEntity) {
    }
}
