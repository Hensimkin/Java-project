package animal;

import graphics.ZooPanel1;
import mobility.Point;

public abstract class AnimalDecorator
{
    protected Animal animal;


    public AnimalDecorator(Animal animal)
    {
        this.animal = animal;
    }

    public void loadColor(String color)
    {
        animal.loadImages(color);
    }

    public void setColor(String color)
    {
        animal.setColor(color);
    }

}
