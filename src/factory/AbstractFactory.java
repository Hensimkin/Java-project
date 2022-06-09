package factory;

import animal.Animal;
import graphics.ZooPanel1;

public abstract class  AbstractFactory
{
    abstract public Animal getAnimal(String animalType, String name, int size, String c, int num1, int num2, ZooPanel1 zoo);
}
