package factory;

import animal.Animal;
import animal.Bear;
import animal.Lion;
import graphics.ZooPanel1;

public class OmnivoreFacory extends AbstractFactory {

    @Override
    public Animal getAnimal(String animalType, String name, int size, String c, int num1, int num2, ZooPanel1 zoo)
    {
        if(animalType=="Bear")
        {
            return new Bear(name,size,c,num1,num2,zoo);
        }
        return null;
    }
}
