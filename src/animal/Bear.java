package animal;

import java.awt.Color;

import diet.IDiet;
import diet.Omnivore;
import food.*;
import graphics.ZooPanel1;
import mobility.*;
import utilities.MessageUtility;

/**
 * a bear type of animal that extend the roar class
 * * @author Hen simkin 
 * @author Adir melker
 */
public class Bear extends Roar
{
	private final static Point start=new Point(100,5);
	private final static IDiet diet=new Omnivore();
	String fur;
	private ZooPanel1 z;
	
	/**
	 * a contractor the give the animal a name
	 * @param name
	 */
	public Bear(String name)
	{
		super(name,start);
		MessageUtility.logConstractor("Bear", name);
		super.setWeight(308.2);
		setFurColor("GREY");
		super.setDiet(diet);
	}
	
	public Bear(String name, int size, String col, int horSpeed, int verSpeed, ZooPanel1 z)
	{
		super(name,start,size,col,horSpeed,verSpeed,z);
		super.setWeight(308.2);
		setFurColor("GREY");
		super.setDiet(diet);
		this.z=z;
		super.loadImages("lio");
		super.setChanges(true);
		this.z.repaint();
	}
	
	/**
	 * a contractor the give the animal a name and start point
	 * @param name
	 * @param point
	 */
	public Bear(String name,Point point)
	{
		super(name,point);
		MessageUtility.logConstractor("Bear", name);
		super.setWeight(308.2);
		setFurColor("GREY");
		super.setDiet(diet);
	}


	
	public EFoodType getFoodtype() 
	{
		return EFoodType.MEAT;
	}


	/**
	 * check if the bear can eat that food 
	 * @param food
	 * 			food type 
	 * @return
	 * 		true if he can eat this food,or false if he dont
	 */
	public boolean eat(IEdible food) 
	{
		double weight1=super.getDiet().eat(this, food);
		if (weight1>0)
		{
			super.setWeight(weight1);
			super.makeSound();
			return true;
		}
		else
		{
			return false;
		}
	}

	
	
	public String toString() 
	{
		return "[Bear:]" + super.getName();
	}
	
	
	
	public void roar()
	{
		MessageUtility.logSound(super.getName(),"Stands on its hind legs, roars and scratches its belly");
	}
	
	
	
	public String getFur()
	{
		MessageUtility.logGetter(this.getName(), "getFur", fur);
		return this.fur;
	}
	
	
	/**
	 * check the color of the fur and print the details
	 * @param color
	 * 			the color of the fur
	 * @return	
	 * 		true if the fur is the color white black and white else return false
	 */
	public boolean setFurColor(String color)
	{
		if (color=="GREY"||color=="BLACK"||color=="WHITE")
		{
			this.fur=color;
			MessageUtility.logSetter(this.getName(), "setFurColor", color, true);
			return true;
		}
		else
		{
			MessageUtility.logSetter(this.getName(), "setFurColor", color, false);
			return false;
		}
	}
	 
	public void dircheck(Point p)
	{
		if(start.checkx(p)==true)
		{
			super.setX_dir(1);
		}
		else
		{
			super.setX_dir(-1);
		}
	}
	
	

}
