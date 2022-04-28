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
import diet.*;
import food.*;
import mobility.*;
import plants.*;
import utilities.*;
import zoo.*;

/**
 * class that make and add buttons to the panel in the main frame
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class ZooPanel1 extends JPanel implements Runnable ,ActionListener {
	JPanel jj;
	int i = 0;
	Plant plant = null;
	Animal ao = null;
	//AddAnimalDialog a;
	String name;
	Table z;
	Color c = null;
	private int check=0;
	private static final String BACKGROUND_PATH = "C:\\Users\\hanig\\Desktop\\assignment2_pictures";
	private BufferedImage pic = null;
	//static Animal[] array=new Animal[10];
	//static ArrayList<Animal> array=new ArrayList<Animal>(10);
	static ArrayList<Animal> array = new ArrayList<Animal>();
	JTable table;
	static String[] col = {"Animal", "Color", "weight", "Hor.Speed", "Ver.Speed", "Eat Counter"};
	static Object[][] data = new Object[10][6];
	private BufferedImage pic2=null;
	private ImageIcon pic3;
	private Image pic4;
	//private JLabel label=new JLabel();


	@Override
	public void run() {

	}

	/**
	 * Default Contractor that add buttons to the panel
	 */
	public ZooPanel1()
	{
		this.setVisible(true);
		this.setLayout(new BorderLayout());
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
	}

	public boolean isChange() {

		if (array.get(0).getChanges() == true) {
			array.get(0).setChanges(false);
			return true;
		}


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
			for(int i =0;i< array.size();i++)
			{
				array.get(i).drawObject(g);
			}
		}
		else
		{

			//Graphics2D gr = (Graphics2D) g;
			//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//Dimension size = this.getSize();
			g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	}
/*
	public void paintComponent2(Graphics g)
	{
		super.paintComponent(g);
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Dimension size = this.getSize();
		gr.drawImage(img, 0, 0, size.width, size.height, this);
	}
*/

	public void setGreen()
	{
		this.setBackground(null);
		//this.paintComponent(this.getGraphics());
		this.setBackground(Color.GREEN);
	}

	public void setNone()
	{
		this.setBackground(null);
	}

     public void setImage()
	 {
		 this.setBackground(null);
		 try
		 {
			 pic = ImageIO.read(new File(BACKGROUND_PATH+"//"+"savanna.png"));
			 this.paintComponent(this.getGraphics());
		 }

		 catch (IOException e)
		 {
			 System.out.println("Cannot load image");
		 }
	 }

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
}






