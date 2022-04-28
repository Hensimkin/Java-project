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
	private static final String BACKGROUND_PATH = "C:\\Users\\hanig\\Desktop\\assignment2_pictures";
	private BufferedImage pic = null;
	//static Animal[] array=new Animal[10];
	//static ArrayList<Animal> array=new ArrayList<Animal>(10);
	static ArrayList<Animal> array = new ArrayList<Animal>();
	JTable table;
	static String[] col = {"Animal", "Color", "weight", "Hor.Speed", "Ver.Speed", "Eat Counter"};
	static Object[][] data = new Object[10][6];


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
		array.get(0).drawObject(g);
	}
}






