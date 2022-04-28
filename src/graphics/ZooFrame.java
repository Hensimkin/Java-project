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

	//private Object[][] data = new Object[10][6];

	//private String[] col = {"Animal", "Color", "weight", "Hor.Speed", "Ver.Speed", "Eat Counter"};

	private JTable table;
    private Table z;
	
	
	
	public ZooFrame()
	{
		super("Zoo");
        m1=new ZooPanel1();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		JPanel downb=new JPanel();
		downb.setLayout(new FlowLayout());

		//this.pack();
		//this.setVisible(true);
		//this.setSize(800,600);


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

        //this.add(m1);
		addanimal=new JButton("Add Animal");
		downb.add(this.addanimal);
		this.addanimal.addActionListener(this);
		moveanimal=new JButton("Move Animal");
		downb.add(this.moveanimal);
		this.moveanimal.addActionListener(this);
		info=new JButton("Info");
		downb.add(this.info);
		this.info.addActionListener(this);
		exit2=new JButton("Exit");
		downb.add(this.exit2);
		this.exit2.addActionListener(this);
		clear=new JButton("Clear");
		downb.add(this.clear);
		this.clear.addActionListener(this);
		food=new JButton("Food");
		downb.add(this.food);
		this.food.addActionListener(this);
		this.add(downb,BorderLayout.SOUTH);
		downb.setBackground(Color.blue);


		this.add(downb, BorderLayout.SOUTH);
		this.add(m1);
		//m1.setVisible(true);
		this.setVisible(true);
		this.pack();
		this.setSize(800,600);

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

			m1.setCheck(1);
			m1.setImage();
			//m1.setVisible(true);
			//m1.repaint();
			m1.setCheck(0);
          /*
			try
			{
				
				this.getContentPane().setBackground(null);
				pic2 = ImageIO.read(new File("C:\\Users\\hanig\\Desktop\\assignment2_pictures\\savanna.png"));
				label.setBounds(0,0,800,600);
				Image pic4 = pic2.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
				pic3 = new ImageIcon(pic4);
				label.setIcon(pic3);
				this.getContentPane().add(label);
				
				//this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("savanna.png")))));
		        
		    }
			catch(IOException ef)
		    {
				System.out.println("Cant load picture");
		    }

           */
           // m1.setImage();
		}
		
		if(e.getSource()==green)
		{
			//ZooPanel m2=new ZooPanel();
			/*
			m.setGreen();
			m.repaint();
			m.setVisible(true);
			//frame.add(m2);
			frame.setVisible(true);


			this.remove(label);
			this.getContentPane().setBackground(Color.green);

			 */

			m1.setGreen();
		}
		
		if(e.getSource()==none)
		{
			/*
			m.setNatural();
			m.repaint();
			m.setVisible(true);
			frame.setVisible(true);


			this.remove(label);
			this.getContentPane().setBackground(null);

			 */
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
			if (AddAnimalDialog.i!=10)
			{
				a=new AddAnimalDialog(m1,this);
				m1.i++;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Can't add more animals","Error",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==moveanimal)
		{
			if (ZooPanel1.array.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Can't move animals","Error",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				MoveAnimalDialog m=new MoveAnimalDialog();
				m1.manageZoo();
			}
		}

		if(e.getSource()==exit2)
		{
			System.exit(0);
		}


		if (e.getSource()==info)
		{
			table=new JTable(ZooPanel1.data,ZooPanel1.col);
			z=new Table(table);
		}
	}
	
	public static void main(String[] args)
	{
		ZooFrame n=new ZooFrame();
	}
		
		
}