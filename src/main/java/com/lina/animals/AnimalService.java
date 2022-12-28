package com.lina.animals;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {

    AnimalRepository animalRepository;

    public Stream<AnimalEntity> all() {
        return animalRepository.all();
    }

    public AnimalEntity createAnimal(String id, String name, String binomialName) {
        return new AnimalEntity(
                UUID.randomUUID().toString(),
                name,
                binomialName,
                "",
                ""
        );
    }

    public AnimalEntity get(String id) {
        return new AnimalEntity(
                id,
                "cat",
                "",
                "",
                ""
        );
    }

    public AnimalEntity update(String id, String name, String binomialName) {
        return new AnimalEntity(
                id,
                name,
                binomialName,
                "",
                ""
        );
    }

    public void deleteAnimal() {}

}
