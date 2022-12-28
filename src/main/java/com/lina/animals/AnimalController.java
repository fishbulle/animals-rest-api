package com.lina.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    AnimalService animalService;

    @GetMapping
    public List<Animal> all() {
        return animalService.all()
                .map(AnimalController::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal) {
        return toDTO(
                animalService.createAnimal(
                        UUID.randomUUID().toString(),
                        createAnimal.getName(),
                        createAnimal.getBinomialName()
                ));
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return new Animal(
                id,
                "cat",
                "",
                "",
                ""
        );
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) {
        return new Animal(
                id,
                "dog",
                "Canis lupus familiaris",
                "",
                ""
        );
    }

    @DeleteMapping("/id")
    public void deleteAnimal() {
    }

    private static Animal toDTO(AnimalEntity animalEntity) {
        return new Animal(
                animalEntity.getId(),
                animalEntity.getName(),
                animalEntity.getBinomialName(),
                animalEntity.getDescription(),
                animalEntity.getConservationStatus()
        );

    }
}
