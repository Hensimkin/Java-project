package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The class that take care of add food option
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class Food extends JFrame implements ActionListener
{
	JButton lettuce;
	JButton cabbage;
	JButton meat;

	ZooPanel1 zoo;
	Food(ZooPanel1 zoo)
	{
		this.zoo=zoo;
		JLabel help=new JLabel();
		ImageIcon icon=new ImageIcon("about.jpeg");
		help.setIcon(icon);
		help.setBounds(150,25,200,100);
		this.setLayout(null);
		this.setSize(400,250);
		this.setVisible(true);
		this.setTitle("Food for animals");
		lettuce=new JButton("lettuce");
		lettuce.setBounds(10,150,100,40);
		lettuce.addActionListener(this);
		this.add(lettuce);
		cabbage=new JButton("Cabbage");
		cabbage.setBounds(130,150,100,40);
		cabbage.addActionListener(this);
		this.add(cabbage);
		meat=new JButton("meat");
		meat.setBounds(250,150,100,40);
		meat.addActionListener(this);
		this.add(meat);
		this.add(help);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cabbage)
		{
			zoo.setFood(1);
			dispose();
		}

		if(e.getSource()==lettuce)
		{
			zoo.setFood(2);
			dispose();
		}
		if(e.getSource()==meat)
		{
			zoo.setFood(3);
			dispose();
		}
	}
}
