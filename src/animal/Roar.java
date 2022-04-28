package animal;

import java.awt.Color;

import graphics.ZooPanel1;
import mobility.Point;

/**
 * a animal that roar after she eat 
* @author Hen simkin 
 * @author Adir melker
 */
public  abstract class Roar extends Animal
{
	public Roar(String name, Point point) 
	{
		super(name, point);
	}
	
	
	public Roar(String name,Point point,int size,String col,int horSpeed,int verSpeed,ZooPanel1 z) 
	{
		super(name,point,size,col,horSpeed,verSpeed,z);
	}

	public abstract void roar();
	
	public void makeSound()
	{
		roar();
	}
}
