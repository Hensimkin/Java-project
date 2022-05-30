package factory;

import diet.Carnivore;
import diet.Omnivore;

public class FactoryProducer
{
    public static AbstractFactory getFactory(String type)
    {
        if(type== "carnivore")
        {
            return new CarnivoreFactory();
        }
        else if(type== "omnivore")
        {
            return new OmnivoreFacory();
        }
        else
        {
            return new HerbivoreFactory();
        }
    }
}
