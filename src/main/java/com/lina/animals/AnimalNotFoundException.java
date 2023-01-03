package com.lina.animals;

public class AnimalNotFoundException extends Exception {

    public AnimalNotFoundException(String id) {
        super(id);
    }
}
