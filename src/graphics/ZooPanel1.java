package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import animal.*;
import food.EFoodType;
import food.IEdible;
import meat.Meat;
import plants.*;

/**
 * class that make and add buttons to the panel in the main frame
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class ZooPanel1 extends JPanel implements Runnable ,ActionListener {
	private int i = 0;
	Plant plant=null;
	Meat meat=null;
	Animal ao = null;
	//AddAnimalDialog a;
	String name;
	Table z;
	Color c = null;
	private int check=0;
	private static final String BACKGROUND_PATH = "C:\\Users\\Adir\\Desktop\\עבודה 2\\assignment2_pictures";
	private BufferedImage pic = null;
	private BufferedImage pic22 = null;
	//static Animal[] array=new Animal[10];
	//static ArrayList<Animal> array=new ArrayList<Animal>(10);
	static ArrayList<Animal> array = new ArrayList<Animal>();
	JTable table;
	static String[] col = {"Animal", "Color", "weight", "Hor.Speed", "Ver.Speed", "Eat Counter"};
	static Object[][] data = new Object[11][6];

	//private BufferedImage pic2=null;
	private ImageIcon pic3;
	private Image pic4;
	//private JLabel label=new JLabel();
	private int t2=0;


	@Override
	public void run() {

	}

	/**
	 * Default Contractor that add buttons to the panel
	 */
	public ZooPanel1()
	{
		//this.setLayout(new BorderLayout());
		try
		{
			pic = ImageIO.read(new File(BACKGROUND_PATH+"//"+"savanna.png"));

			//this.repaint();
		}

		catch (IOException e)
		{
			System.out.println("Cannot load image");
		}
		this.setBackground(null);
		this.setVisible(true);
		data[10][0]="Total";
		data[10][5]=0;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

	public void manageZoo()
	{
		if (isChange()==true)
		{
			this.repaint();
			//revalidate();
		}
		if(plant!=null)
		{
			this.eatfood();

		}
		if(meat!=null)
		{
			this.eatfood();

		}

		if(array.size()>1)
		{
			int count=0;
			for(int i=0;i<array.size();i++)
			{
				for(int j=0;j<array.size();j++)
				{
					count=0;
					if(array.get(i)==array.get(j))
					{
						continue;
					}
					else
					{
						if(array.get(i).calcDistance(array.get(j).getLocation())<array.get(j).getSize())
						{
							count++;
						}

						if(array.get(i).getDiet().canEat(array.get(j).getFoodtype())==true)
						{
							count++;
						}
						if(array.get(i).getWeight()>2*(array.get(j).getWeight()))
						{
							count++;
						}
						if(count==3)
						{
							deleteData(array.get(j).getName());
							JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
							array.get(i).eatInc();
							setFoodInc(array.get(i).getName(),array.get(i));
							array.get(i).setWeight(array.get(i).getWeight()*1.1);
							setWeighInc(array.get(i).getName(),array.get(i));
							this.i--;
							array.remove(j);
							break;
						}
					}
					if(count==3)
					{
						break;
					}
				}
			}
		}

	}

	public boolean isChange()
	{
		/*
		if (array.get(0).getChanges() == true) {
			array.get(0).setChanges(false);
			return true;
		}

		 */


		for (int counter = 0; counter < array.size(); counter++) {
			if (array.get(counter).getChanges() == true) {
				array.get(counter).setChanges(false);
				return true;
			}
		}
		return false;
	}


	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (this.check==0)
		{
			if(t2==1)
			{
				this.drawObject(g);
			}
			if (array.size()!=0)
			{
				for (int i = 0; i < array.size(); i++)
				{
					array.get(i).drawObject(g);
				}
			}
			if(plant!=null)
			{
				plant.drawObject(g);
				check=0;
			}
			if(meat!=null)
			{
				meat.drawObject(g);
				check=0;
			}
		}
		else if(this.check==1)
		{
			Dimension size = this.getSize();
			g.drawImage(pic, 0, 0, size.width, size.height, this);
		}
		/*
		else
		{

		}
         */
	}


	public void setGreen()
	{
		t2=0;
		this.setBackground(null);
		this.setBackground(Color.GREEN);
	}

	public void setNone()
	{
		t2=0;
		this.setBackground(null);
	}
/*
     public void setImage()
	 {
		 //this.setBackground(null);
		 int t2=1;
		 this.paintComponent(this.getGraphics());
	 }

 */

	 public void setCheck(int num)
	 {
		 this.check=num;
	 }
/*
	public void setPic()
	{
		setBackground(null);
		this.paintComponent2(this.getGraphics());
	}

 */

	public void setFood(int num)
	{
		if(num==1)
		{
			this.meat=null;
           this.plant=new Cabbage(this);
		   this.plant.loadImages("cabbage.png");
		  // this.setCheck(2);
		   this.repaint();
		   this.setCheck(0);

		}
		if(num==2)
		{
			this.meat=null;
			this.plant=new Lettuce(this);
			this.plant.loadImages("lettuce.png");
			// this.setCheck(2);
			this.repaint();
			this.setCheck(0);
		}

		if(num==3)
		{
			this.plant=null;
			this.meat=new Meat(this);
			this.meat.loadImages("meat.gif");
			// this.setCheck(2);
			this.repaint();
			this.setCheck(0);
		}
	}

	/*
	public void Image(Graphics g)
	{
		Dimension size = this.getSize();
		g.drawImage(pic, 0, 0, size.width, size.height, this);
	}

	 */



	public void loadPic()
	{
		try
		{
			this.pic22 = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\"+"savanna.png"));
		}
		catch (IOException e)
		{
			System.out.println("Cant load pic");
		}
	}

	public void drawObject (Graphics g)
	{
		this.setBackground(null);
		Dimension size = this.getSize();
		g.drawImage(pic22, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	public void setT2(int num)
	{
		this.t2=num;
	}

	public void updatei(int num)
	{
		if(num==1)
		{
			this.i++;
		}
		else
		{
			this.i--;
		}
	}

	public int getI()
	{
		return this.i;
	}


	public void eatfood()
	{
		int eatcount=1;
		for(Animal ok:array)
		{
			if(ok instanceof Giraffe)
			{
				if(this.plant!=null)
				{
					double distance=ok.calcDistance(plant.getLocation());
					if (distance<=ok.getEAT_DISTANCE())
					{
						ok.eatInc();
						this.plant=null;
						this.repaint();
						JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
						ok.setWeight(ok.getWeight()*1.07);
						setWeighInc(ok.getName(),ok);
						ok.eatInc();
						setFoodInc(ok.getName(),ok);
						break;
					}
				}

			}
			if(ok instanceof Lion)
			{
				if(this.meat!=null)
				{
					double distance=ok.calcDistance(meat.getLocation());
					if (distance<=ok.getEAT_DISTANCE())
					{
						//ok.eatInc();
						this.meat=null;
						this.repaint();
						JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
						ok.setWeight(ok.getWeight()*1.1);
						setWeighInc(ok.getName(),ok);
						ok.eatInc();
						setFoodInc(ok.getName(),ok);
						break;
					}
				}
			}
			if (ok instanceof Bear)
			{
				if(this.plant!=null)
				{
					double distance=ok.calcDistance(plant.getLocation());
					if (distance<=ok.getEAT_DISTANCE())
					{
						//ok.eatInc();
						this.plant=null;
						this.repaint();
						JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
						ok.setWeight(ok.getWeight()*1.07);
						setWeighInc(ok.getName(),ok);
						ok.eatInc();
						setFoodInc(ok.getName(),ok);
						break;
					}
				}
				else
				{
					double distance=ok.calcDistance(meat.getLocation());
					if (distance<=ok.getEAT_DISTANCE())
					{
						//ok.eatInc();
						this.meat=null;
						this.repaint();
						JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
						ok.setWeight(ok.getWeight()*1.1);
						setWeighInc(ok.getName(),ok);
						ok.eatInc();
						setFoodInc(ok.getName(),ok);
						break;
					}
				}
			}
			if(ok instanceof Elephant)
			{
				if(this.plant!=null)
				{
					double distance=ok.calcDistance(plant.getLocation());
					if (distance<=ok.getEAT_DISTANCE())
					{
						//ok.eatInc();
						this.plant=null;
						this.repaint();
						JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
						ok.setWeight(ok.getWeight()*1.07);
						setWeighInc(ok.getName(),ok);
						ok.eatInc();
						setFoodInc(ok.getName(),ok);
						break;
					}
				}
			}
			if(ok instanceof Turtle)
			{
				if(this.plant!=null)
				{
					double distance=ok.calcDistance(plant.getLocation());
					if (distance<=ok.getEAT_DISTANCE())
					{
						//ok.eatInc();
						this.plant=null;
						this.repaint();
						JOptionPane.showMessageDialog(null, "Animal has eat","success",JOptionPane.INFORMATION_MESSAGE);
						ok.setWeight(ok.getWeight()*1.07);
						setWeighInc(ok.getName(),ok);
						ok.eatInc();
						setFoodInc(ok.getName(),ok);
						break;
					}
				}
			}
		}
	}

	public void setFoodInc(String name,Animal ao)
	{
		for(int i=0;i<this.i;i++)
		{
			if(data[i][0]==name)
			{
				data[i][5]=ao.getEatCount();
			}
		}
	}


	public void setWeighInc(String name,Animal ao)
	{
		for(int i=0;i<this.i;i++)
		{
			if(data[i][0]==name)
			{
				data[i][2]=ao.getWeight();
			}
		}
	}

	public void deleteData(String name)
	{
		int counter=0;
		Object[][] data2 = new Object[11][6];
		for(int i=0;i<this.i;i++)
		{
			if(name!=data[i][0])
			{
				for(int j=0;j<6;j++)
				{
					{
						data2[i][j]=data[i][j];
					}
				}
			}
			else
			{
				i++;
			}
		}
		data2[10][0]="Total";
		for(int i=0;i<this.i;i++)
		{
			if(name!=data[i][0])
			{
				counter=counter+(int)data[i][5];
			}
			else
			{
				i++;
			}
		}
		data2[10][5]=counter;
		data=data2;
	}

    public void setI(int num)
	{
		this.i=num;
	}

}
