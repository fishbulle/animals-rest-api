package com.lina.animals;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Animal> get(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(toDTO(animalService.getAnimal(id)));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable("id")
                                         String id,
                                         @RequestBody UpdateAnimal updateAnimal) {
        try {
            return ResponseEntity.ok(toDTO(
                    animalService.updateAnimal(
                            id,
                            updateAnimal.getName(),
                            updateAnimal.getBinomialName(),
                            updateAnimal.getDescription(),
                            updateAnimal.getConservationStatus())));
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {
            animalService.deleteAnimal(id);
            return ResponseEntity.ok().build();
        } catch (AnimalNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
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
