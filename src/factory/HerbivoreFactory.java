package factory;

import animal.*;
import graphics.ZooPanel1;

public class HerbivoreFactory extends AbstractFactory
{
    @Override
    public Animal getAnimal(String animalType, String name, int size, String c, int num1, int num2, ZooPanel1 zoo)
    {
        if(animalType=="Elephant")
        {
            return new Elephant(name,size,c,num1,num2,zoo);
        }
        if(animalType=="Giraffe")
        {
            return new Giraffe(name,size,c,num1,num2,zoo);
        }
        if(animalType=="Turtle")
        {
            return new Turtle(name,size,c,num1,num2,zoo);
        }
        return null;
    }
}
