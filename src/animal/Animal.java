package animal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diet.*;
import food.*;
import mobility.*;
import utilities.*;
import graphics.*;

/**
 * class that represent an animal
 * @author Hen simkin 
 * @author Adir melker
 */
public abstract class Animal  extends Mobile implements  IEdible, IDrawable,IAnimalBehavior//,Runnable
{
	private String name;
	private double weight;
	private IDiet diet;
	private final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged=false;
	//private Thread thread;
	private int x_dir=1;
	private int y_dir=1;
	private int eatCount=0;
	private ZooPanel1 pan;
	private BufferedImage img1=null, img2=null;
	protected Thread thread;
	protected boolean threadSuspended;
	
	
	
	/**
	 * constractor that get name and point
	 * @param name
	 * 			the name of the animal
	 * @param point
	 * 			starting point of the animal
	 */
	public Animal(String name,Point point)
	{
		super(point);
		MessageUtility.logConstractor("Animal", name);
		setName(name);
	}
	
	public Animal(String name,Point point,int size,String col,int horSpeed,int verSpeed,ZooPanel1 z)
	{
		super(point);
		this.size=size;
		this.col=col;
		this.horSpeed=horSpeed;
		this.verSpeed=verSpeed;
		this.name=name;
		this.pan=z;
	}
	
	
	public abstract boolean eat(IEdible food);
	
	
	
	public abstract void makeSound();
	
	
	/**
	 *	set the weight of the animal 
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight)
	{
		this.weight=weight;
		MessageUtility.logSetter(this.name, "setWeight", this.weight, true);
		return true;
	}
	
	
	
	/**
	 * set the diet of the animal
	 * @param diet
	 * @return
	 */
	public boolean setDiet(IDiet diet)
	{
		this.diet=diet;
		MessageUtility.logSetter(this.name, "setDiet", this.diet, true);
		return true;
	}
	
	
	/**
	 * return the name of the animal
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	
	
	public abstract String toString();
	
	
	
	public IDiet getDiet()
	{
		return this.diet;
	}
	
	
	
	public double getWeight()
	{
		MessageUtility.logGetter(this.name, "getWeight", this.weight);
		return this.weight;
	}
	
	
	
	public boolean setName(String name)
	{
		this.name=name;
		MessageUtility.logSetter(this.name, "setName", this.name, true);
		return true;
	}


	
	/**
	 *	function that decrease the weight of the animal depend the total the distance he walk
	 *	and update is new location 
	 * @param p	
	 * 		the point the animal walk
	 * @return
	 * 		the total distance
	 */
	public double move(Point p)
	{
		double tempWight;
		if(super.calcDistance(p)>0)
		{
			tempWight=this.weight-(0.00025*this.weight*super.calcDistance(p));
			setWeight(tempWight);
			super.addTotalDistance(calcDistance(p));
			super.setLocation(p);
			return super.getTotaldistance();
			
		}
		else
		{
			return 0;
		}
	}
	
	public int getEatCount()
	{
		return this.eatCount;
	}
	
	public String getAnimalName()
	{
		return this.name;
	}
	
	public String getPicturePatch()
	{
		return this.PICTURE_PATH;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	
	public void eatInc()
	{
		this.eatCount++;
	}
	
	public void setChanges(boolean state)
	{
		coordChanged=state;
	}
	
	
	public boolean getChanges()
	{
		return this.coordChanged;
	}
	
	public String getColor()
	{
		return this.col;
	}
	
	public int getX_dir()
	{
		return this.x_dir;
	}
	
	
	public int getY_dir()
	{
		return this.y_dir;
	}
	
	
	public void setX_dir(int num)
	{
		this.x_dir=num;
	}
	
	
	public void setY_dir(int num)
	{
		 this.y_dir=num;
	}
	
	public BufferedImage getBufferedImage1()
	{
		return this.img1;
	}
	
	public BufferedImage getBufferedImage2()
	{
		return this.img2;
	}
	
	public void setBufferedImage()
	{
		try
		{
			img1=ImageIO.read(new File(PICTURE_PATH));
		}
		catch(IOException e)
		{
			System.out.println("Cant load picture");
		}
		
	}
	@Override
	public void drawObject (Graphics g)
	{
		 if(this.x_dir==1) 
		 {
			 g.drawImage(img1, this.getLocation().getX()-this.size/2, this.getLocation().getY()-this.size/10, this.size/2, this.size, this.pan);
		 }
		
		 else 
		 {
			 g.drawImage(img2, this.getLocation().getX(), this.getLocation().getY()-this.size/10, this.size/2, this.size, this.pan);
		 }
		
	}
	
	
	public ZooPanel1 getPanel()
    {
		return this.pan;
	}
	

	public void setPanel(ZooPanel1 z)
    {
		this.pan=z;
	}
	
	public void loadImages(String nm)
	{
		try
        {
			if(this.col=="Blue")
			{
				this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_b_1.png"));
				this.img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_b_2.png"));
				System.out.println("Animal drawed");
			}
			else if(this.col=="Red")
			{
				this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_r_1.png"));
				this.img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_r_2.png"));
				System.out.println("Animal drawed");
			}
			else if(this.col=="Natural")
			{
				this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_n_1.png"));
				this.img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+nm+"_n_2.png"));
				System.out.println("Animal drawed");
			}
			else
			{
				System.out.println("Animal not drawed");
			}
        }
        catch (IOException e)
        {
            System.out.println("Cannot load image");
        }
	}

	public int getEAT_DISTANCE()
	{
		return this.EAT_DISTANCE;
	}

}
