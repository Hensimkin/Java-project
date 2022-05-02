package animal;
import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel1;
import mobility.*;
import diet.IDiet;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * a lion type of animal that extend the roar class
* @author Hen simkin 
 * @author Adir melker
 */
public class Lion extends Roar
{
	//private final Point start=new Point(20,0);
	private Point start=new Point(20,0);
	private final static IDiet diet=new Carnivore();
	private int scarCount=0;
	private ZooPanel1 z;
	
	/**
	 * a contractor the give the animal a name
	 * @param name
	 */
	public Lion(String name)
	{
		super(name,new Point(20,0));
		MessageUtility.logConstractor("Lion", name);
		super.setWeight(408.2);
		super.setDiet(diet);
	}
	
	public Lion(String name,int size,String col,int horSpeed,int verSpeed,ZooPanel1 z)
	{
		super(name,new Point(20,0),size,col,horSpeed,verSpeed,z);
		super.setWeight(408.2);
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
	public Lion(String name,Point point)
	{
		super(name,new Point(20,0));
		MessageUtility.logConstractor("Lion", name);
		super.setWeight(408.2);
		super.setDiet(diet);
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
		int z;
		double weight1=super.getDiet().eat(this, food);
		if (weight1>0)
		{
			Random temp=new Random();
			z=temp.nextInt(2);
			this.scarCount=this.scarCount+z;
			super.setWeight(weight1);
			super.makeSound();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public EFoodType getFoodtype()
	{
		return EFoodType.NOTFOOD;
	}

	
	
	public String toString() 
	{
		return "[Lion:]" + super.getName();
	}
	
	
	
	public int getScars()
	{
		MessageUtility.logGetter(this.getName(), "getScars", scarCount);
		return this.scarCount;
	}
	
    
	
	public void roar()
	{
		MessageUtility.logSound(super.getName(),"Roars, then stretches and shakes its mane");
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
