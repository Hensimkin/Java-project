package factory;

import animal.Animal;

public abstract class AbstractFactory
{
    abstract Animal getAnimal(String animalType);
}
