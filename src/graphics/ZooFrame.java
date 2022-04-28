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

	
	
	
	public ZooFrame()
	{
		ZooPanel1 m=new ZooPanel1();
		//m.setOpaque(false);
		this.setName("Zoo");
		this.setVisible(true);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(m,BorderLayout.PAGE_END);
		label=new JLabel();
		//this.add(label);
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
			*/
			this.remove(label);
			this.getContentPane().setBackground(Color.green);
			
		}
		
		if(e.getSource()==none)
		{
			/*
			m.setNatural();
			m.repaint();
			m.setVisible(true);
			frame.setVisible(true);
			*/
			this.remove(label);
			this.getContentPane().setBackground(null);
			
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
		
	}
	
	public static void main(String[] args)
	{
		ZooFrame n=new ZooFrame();
	}
		
		
}