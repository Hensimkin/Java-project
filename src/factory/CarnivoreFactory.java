package factory;

import animal.Animal;
import animal.Lion;
import graphics.ZooPanel1;

public class CarnivoreFactory extends AbstractFactory
{
    @Override
    public Animal   getAnimal(String animalType, String name, int size, String c, int num1, int num2, ZooPanel1 zoo)
    {
        if(animalType=="Lion")
        {
            return new Lion(name,size,c,num1,num2,zoo);
        }
        return null;
    }
}
