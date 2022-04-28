package graphics;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The class that take care of add food option
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class Food extends JFrame
{
	Food()
	{
		JLabel help=new JLabel();
		ImageIcon icon=new ImageIcon("about.jpeg");
		help.setIcon(icon);
		help.setBounds(150,25,200,100);
		this.setLayout(null);
		this.setSize(400,250);
		this.setVisible(true);
		this.setTitle("Food for animals");
		JButton lettuce=new JButton("lettuce");
		lettuce.setBounds(10,150,100,40);
		this.add(lettuce);
		JButton cabbage=new JButton("Cabbage");
		cabbage.setBounds(130,150,100,40);
		this.add(cabbage);
		JButton meat=new JButton("Meat");
		meat.setBounds(250,150,100,40);
		this.add(meat);
		this.add(help);
	}
}
