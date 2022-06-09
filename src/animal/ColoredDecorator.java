package animal;

public class ColoredDecorator extends AnimalDecorator
{
    private String color;

    public ColoredDecorator(Animal animal)
    {
        super(animal);
    }

    public void loadColor(String color)
    {
        super.loadColor(color);
    }


    public void setColor(String color)
    {
        super.setColor(color);
    }

}
