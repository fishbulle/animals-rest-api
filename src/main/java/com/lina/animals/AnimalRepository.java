package com.lina.animals;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class AnimalRepository {

    Map<String, AnimalEntity> animals = new HashMap<>();

    public Stream<AnimalEntity> all() {
        return animals.values().stream();
    }

    public AnimalEntity save(AnimalEntity animalEntity) {
        animals.put(animalEntity.getId(), animalEntity);
        return animalEntity;
    }

    public AnimalEntity get(String id) {
        return animals.get(id);
    }

    public void delete(AnimalEntity animalEntity) {
        animals.remove(animalEntity.getId());
    }
}
