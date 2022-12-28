package com.lina.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GetMapping
    public List<Animal> all() {
        return List.of(
                new Animal(UUID.randomUUID().toString(), "cat", "Felis catus", "", ""),
                new Animal(UUID.randomUUID().toString(), "dog", "Canis lupus familiaris", "", ""));
    }

    @PostMapping
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal) {
        return new Animal(
                UUID.randomUUID().toString(),
                createAnimal.getName(),
                createAnimal.getBinomialName(),
                "",
                ""
        );
    }
}
