package animal;

import java.awt.Color;

import diet.Herbivore;
import diet.IDiet;
import graphics.ZooPanel1;
import mobility.*;
import utilities.MessageUtility;
import food.*;
/**
  * a elephant type of animal that extend the chew class 
 * @author Hen simkin 
 * @author Adir melker
 */
public class Elephant extends Chew
{
	private  Point start=new Point(50,90);
	private final static IDiet diet=new Herbivore();
	private double trunkLengh=1;
	private ZooPanel1 z;

	/**
	 * a contractor the give the animal a name
	 * @param name
	 */
	public Elephant(String name)
	{
		super(name,new Point(50,90));
		MessageUtility.logConstractor("Elephant", name);
		super.setWeight(500);
		setTrunkLengh(trunkLengh);
		super.setDiet(diet);
	}
	
	
	public Elephant(String name, int size, String col, int horSpeed, int verSpeed, ZooPanel1 z)
	{
		super(name,new Point(50,90),size,col,horSpeed,verSpeed,z);
		super.setWeight(500);
		setTrunkLengh(trunkLengh);
		super.setDiet(diet);
		this.z=z;
		super.loadImages("elf");
		super.setChanges(true);
		this.z.repaint();
	}
	
	/**
	 * a contractor the give the animal a name and start point
	 * @param name
	 * @param point
	 */
	public Elephant(String name,Point point)
	{
		super(name,point);
		MessageUtility.logConstractor("Elephant", name);
		super.setWeight(500);
		setTrunkLengh(trunkLengh);
		super.setDiet(diet);
	}


	
	public EFoodType getFoodtype() 
	{
		return EFoodType.MEAT;
	}


	
	public void chew() 
	{
		MessageUtility.logSound(super.getName(),"Trumpets with joy while flapping its ears, then chews");
	}


	/**
	 * check if the elephant can eat that food 
	 * @param food
	 * 			food type 
	 * @return
	 * 		true if he can eat this food,or false if he dont
	 */
	public boolean eat(IEdible food) {
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
		return "[Elephant:]" + super.getName();
	}
	
	/**
	 * check if the length of the trunk is legal and update the length,also print the details.
	 * @param lengh
	 * 			the length of the trunk
	 * @return
	 * 		true if the length is legal else return false
	 */
	public boolean setTrunkLengh(double lengh)
	{
		if (lengh>=0.5 && lengh <=3)
		{
			this.trunkLengh=lengh;
			MessageUtility.logSetter(this.getName(), "setTrunkLengh", lengh, true);
			return true;
		}
		else
		{
			MessageUtility.logSetter(this.getName(), "setTrunkLengh", lengh, false);
			return false;
		}
	}
	
	public double getTrunkLengh()
	{
		MessageUtility.logGetter(this.getName(), "getTrunkLengh", trunkLengh);
		return this.trunkLengh;
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
