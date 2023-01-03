package com.lina.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Animal create(@RequestBody CreateAnimal createAnimal) {
        return toDTO(
                animalService.createAnimal(
                        createAnimal.getName(),
                        createAnimal.getBinomialName(),
                        createAnimal.getDescription(),
                        createAnimal.getConservationStatus()
                ));
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return toDTO(
                animalService.getAnimal(id));
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id")
                         String id,
                         @RequestBody UpdateAnimal updateAnimal) {
        return toDTO(
                animalService.updateAnimal(
                        id,
                        updateAnimal.getName(),
                        updateAnimal.getBinomialName(),
                        updateAnimal.getDescription(),
                        updateAnimal.getConservationStatus()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        animalService.deleteAnimal(id);
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
