package meat;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel1;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Meat implements IEdible,IDrawable
{
    private double height;
    /**
     *
     */
    private mobility.Point location;
    /**
     *
     */
    private double weight;

    /**
     *
     */
    private ZooPanel1 zoo;
    /**
     *
     */
    private BufferedImage img = null;
    /**
     *
     */
    public Meat(ZooPanel1 zoo) {
        Random rand = new Random();
       // int x = rand.nextInt(30);
       // int y = rand.nextInt(12);
        int x=400;
        int y=300;
        this.location = new Point(x, y);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
        MessageUtility.logConstractor("Meat", "Meat");
        this.zoo=zoo;
    }


    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }


    public double getHeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }


    public Point getLocation() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }





    public double getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }


    public boolean setHeight(double height) {

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#setLocation(mobility.Point)
     */

    public boolean setLocation(Point newLocation) {
        boolean isSuccess = Point.cheackBounderies(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }


    public boolean setWeight(double weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }


    @Override
    public void loadImages(String nm)
    {
        try
        {
            img = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm));
        }
        catch (IOException e)
        {
            System.out.println("Cant load picture");
        }
    }

    @Override
    public void drawObject(Graphics g)
    {
        g.drawImage(img, 400, 300, 40, 40, zoo);
    }

    @Override
    public String getColor() {
        return null;
    }

    public String getColor2() {
        return null;
    }


}



