package com.lina.animals;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

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
}
