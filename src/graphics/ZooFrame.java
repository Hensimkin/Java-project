package graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
 * class that make the main frame of the program
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class ZooFrame extends JFrame implements ActionListener
{
	private static final String BACKGROUND_PATH="C:\\Users\\hanig\\Desktop\\assignment2_pictures";
	//static JFrame frame;
	static JLabel label;
	static BufferedImage pic2=null;
	static ImageIcon pic3;
	static Image pic4;
	private JMenu file;
	private JMenu background;
	private JMenu help;
	private JMenuItem exit;
	private JMenuItem green;
	private JMenuItem none;
	private JMenuItem image;
	private JMenuItem help2;
	private JButton addanimal;
	private JButton moveanimal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit2;
	private AddAnimalDialog a;
	private ZooPanel1 m1;
	private BufferedImage pic;

	private JButton sleep;
	private JButton wakeUp;

	private JButton color;
	private JButton saveState;
	private JButton restoreState;

	//private Object[][] data = new Object[10][6];

	//private String[] col = {"Animal", "Color", "weight", "Hor.Speed", "Ver.Speed", "Eat Counter"};

	private JTable table;
    private Table z;
	private String type;
	
	
	public ZooFrame()
	{
		super("Zoo");
        m1=new ZooPanel1();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		JPanel downb=new JPanel();
		downb.setLayout(new FlowLayout());
		label=new JLabel();
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu file=new JMenu("File");
		menuBar.add(file);
		JMenu background=new JMenu("Background");
		menuBar.add(background);
		help=new JMenu("Help");
		menuBar.add(help);
		exit=new JMenuItem("Exit");
		file.add(exit);
		exit.addActionListener(this);
		image=new JMenuItem("Image");
		background.add(image);
		image.addActionListener(this);
		green=new JMenuItem("Green");
		background.add(green);
		green.addActionListener( this);
		none=new JMenuItem("None");
		background.add(none);
		none.addActionListener( this);
		help2=new JMenuItem("Help");
		help.add(help2);
		help2.addActionListener(this);
		addanimal=new JButton("Add Animal");
		downb.add(this.addanimal);
		this.addanimal.addActionListener(this);
		sleep=new JButton("Sleep");
		downb.add(this.sleep);
		this.sleep.addActionListener(this);
		//moveanimal=new JButton("Move Animal");
		//downb.add(this.moveanimal);
		//this.moveanimal.addActionListener(this);
		this.color=new JButton("Color");
		downb.add(this.color);
		this.color.addActionListener(this);
		wakeUp=new JButton("Wake up");
		downb.add(this.wakeUp);
		this.wakeUp.addActionListener(this);
		clear=new JButton("Clear");
		downb.add(this.clear);
		this.clear.addActionListener(this);
		saveState=new JButton("Save State");
		downb.add(this.saveState);
		this.saveState.addActionListener(this);
		restoreState=new JButton("Restore State");
		downb.add(this.restoreState);
		this.restoreState.addActionListener(this);
		food=new JButton("Food");
		downb.add(this.food);
		this.food.addActionListener(this);
		info=new JButton("Info");
		downb.add(this.info);
		this.info.addActionListener(this);
		exit2=new JButton("Exit");
		downb.add(this.exit2);
		this.exit2.addActionListener(this);
		this.add(downb,BorderLayout.SOUTH);
		downb.setBackground(Color.blue);
		this.add(downb, BorderLayout.SOUTH);
		this.add(m1);
		this.setVisible(true);
		this.pack();
		this.setSize(800,600);
		m1.controllerst();
		//m1.getThread().start();

	}

	public void setType1(String s)
	{
		type=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==exit)
		{
			System.exit(0);
		}
		
		if (e.getSource()==image)
		{

			m1.setCheck(0);
			m1.setT2(1);
			m1.loadPic();
			m1.repaint();
			m1.setCheck(0);

		}
		
		if(e.getSource()==green)
		{
			m1.setGreen();
		}
		
		if(e.getSource()==none)
		{
			m1.setNone();
		}
		
		if(e.getSource()==help2)
		{
			JFrame frameMessage=new JFrame("Message");
			JLabel labelWork2=new JLabel("<html>Home Work 2<br/>GUI</html>");
			frameMessage.setSize(300,300);
			frameMessage.setVisible(true);
			frameMessage.add(labelWork2);
			ImageIcon aboutIcon=new ImageIcon("about.jpeg");
			labelWork2.setIcon(aboutIcon);
			JButton btOk=new JButton("OK");
			btOk.setFocusable(false);
			btOk.setBounds(150,150,70,30);
			labelWork2.add(btOk);	
			btOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{  
					frameMessage.dispose();
			    }
			});
		}

		if(e.getSource()==addanimal)
		{
			if(ZooPanel1.array.size()<=15)
			{
				new Animsec(m1,this);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Can't add animals","Error",JOptionPane.WARNING_MESSAGE);
			}
			//a = new AddAnimalDialog(m1, this);

		}
		/*
		if(e.getSource()==moveanimal)
		{
			if (ZooPanel1.array.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Can't move animals","Error",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				MoveAnimalDialog m=new MoveAnimalDialog(m1);
				m1.manageZoo();
			}


		}
		*/
		if(e.getSource()==exit2)
		{
			System.exit(0);
		}


		if (e.getSource()==info)
		{
			table=new JTable(ZooPanel1.data,ZooPanel1.col);
			z=new Table(table);
		}

		if (e.getSource()==clear)
		{
			for(int i=0;i<ZooPanel1.array.size();i++)
			{
				if(ZooPanel1.array.get(i) instanceof Lion)
				{
					AddAnimalDialog.lionc--;
				}
				if(ZooPanel1.array.get(i) instanceof Bear)
				{
					AddAnimalDialog.bearc--;
				}
				if(ZooPanel1.array.get(i) instanceof Elephant)
				{
					AddAnimalDialog.elephantc--;
				}
				if(ZooPanel1.array.get(i) instanceof Giraffe)
				{
					AddAnimalDialog.giraffec--;
				}
				if(ZooPanel1.array.get(i) instanceof Turtle)
				{
					AddAnimalDialog.turtlec--;
				}
			}
			for(int i=0;i<ZooPanel1.array.size();i++)
			{
				ZooPanel1.array.get(i).setFlag(false);
			}
			int k=ZooPanel1.array.size();
			ZooPanel1.array.clear();
			for(int i=0;i<k;i++)
			{
				ZooPanel1.data[i][0]=null;
				ZooPanel1.data[i][1]=null;
				ZooPanel1.data[i][2]=null;
				ZooPanel1.data[i][3]=null;
				ZooPanel1.data[i][4]=null;
				ZooPanel1.data[i][5]=null;
			}
			ZooPanel1.data[10][5]=0;
			m1.setI(0);
			m1.repaint();
		}

		if (e.getSource()==food)
		{
			new Food(m1);
		}

		if (e.getSource()==sleep)
		{
			try {
				m1.sleepAll();
			} catch (InterruptedException ex) {
				throw new RuntimeException(ex);
			}
		}
		if (e.getSource()==wakeUp)
		{
			m1.wakeAll();
		}

		if(e.getSource()==color)
		{
			if (m1.getI()!=0)
			{
				new ColorChange(m1);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Can't change color","Error",JOptionPane.WARNING_MESSAGE);
			}

		}
		if(e.getSource()==saveState)
		{
			try {
				m1.savememento();
			} catch (CloneNotSupportedException ex) {
				throw new RuntimeException(ex);
			}
		}
		if(e.getSource()==restoreState)
		{
			try {
				m1.restoremomento();
			} catch (CloneNotSupportedException ex) {
				throw new RuntimeException(ex);
			}
		}
	}


	
	public static void main(String[] args)
	{
		ZooFrame n=new ZooFrame();
	}
		
		
}