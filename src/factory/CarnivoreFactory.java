package factory;

import animal.Animal;

public class CarnivoreFactory extends AbstractFactory
{

    @Override
    Animal getAnimal(String animalType)
    {
        if(animalType=="Lion")
        {
            System.out.println("gh");
        }
        return null;
    }
}
