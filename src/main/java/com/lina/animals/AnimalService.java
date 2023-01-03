package com.lina.animals;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {

    AnimalRepository animalRepository;

    public Stream<AnimalEntity> all() {
        return animalRepository.all();
    }

    public AnimalEntity createAnimal(String name,
                                     String binomialName,
                                     String description,
                                     String conservationStatus) {
        AnimalEntity animalEntity = new AnimalEntity(
                UUID.randomUUID().toString(),
                name,
                binomialName,
                description,
                conservationStatus
        );
        return animalRepository.save(animalEntity);
    }

    public AnimalEntity getAnimal(String id) throws AnimalNotFoundException {
        return animalRepository.get(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    public AnimalEntity updateAnimal(String id,
                                     String name,
                                     String binomialName,
                                     String description,
                                     String conservationStatus) throws AnimalNotFoundException {
        AnimalEntity animalEntity = animalRepository.get(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
        animalEntity.setName(name);
        animalEntity.setBinomialName(binomialName);
        animalEntity.setDescription(description);
        animalEntity.setConservationStatus(conservationStatus);
        return animalRepository.save(animalEntity);
    }

    public void deleteAnimal(String id) throws AnimalNotFoundException {
        AnimalEntity animalEntity = animalRepository.get(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
        animalRepository.delete(animalEntity);
    }
}
