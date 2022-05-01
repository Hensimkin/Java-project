package graphics;
import mobility.*;
import animal.*;

import javax.swing.*;

import animal.Animal;

import java.awt.GridLayout;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The class that take care of move animal option
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */

public class MoveAnimalDialog extends JDialog implements ActionListener
{
	 JComboBox allAniaml;
	 JButton move;
	 JTextField xFiled;
	 JTextField yFiled;
	 String type;
	 Animal animal;
	 int x,y;
	 Point p;
	 int lionc=1,bearc=1,elephantc=1,giraffec=1,turtlec=1;
	 String f;
	 String type2;
	 int i2;
	 ZooPanel1 zoo;
	public MoveAnimalDialog(ZooPanel1 zoo)
	{
		this.setLayout(new GridLayout(4,1));
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("Move Animal");
		String[]animals=new String[zoo.getI()];
		Object ob;
		for (int i=0;i<zoo.getI();i++)
		{
			ob=ZooPanel1.array.get(i);
			if(ob instanceof Lion)
			{
				animals[i]=((Lion) ob).getName();
			}
			if(ob instanceof Bear)
			{
				animals[i]=((Bear) ob).getName();
			}
			if(ob instanceof Elephant)
			{
				animals[i]=((Elephant) ob).getName();
			}
			if(ob instanceof Giraffe)
			{
				animals[i]=((Giraffe) ob).getName();
			}
			if(ob instanceof Turtle)
			{
				animals[i]=((Turtle) ob).getName();
			}
		}
		JLabel labelAnimal=new JLabel("select animal");
		this.add(labelAnimal);
		allAniaml=new JComboBox(animals);
		allAniaml.addActionListener(this);
		this.add(allAniaml);
		JLabel labelX=new JLabel("enter x (0-800)");
		this.add(labelX);
		xFiled=new JTextField();
		this.add(xFiled);
		xFiled.addActionListener(this);
		JLabel labelY=new JLabel("enter y (0-600)");
		this.add(labelY);
		yFiled=new JTextField();
		this.add(yFiled);
		yFiled.addActionListener(this);
		JLabel finish=new JLabel("Press to finish");
		this.add(finish);
		move=new JButton("Accept");
		this.add(move);
		move.addActionListener(this);
		this.zoo=zoo;

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{		
		if (e.getSource()==move)
		{
			x=Integer.parseInt(xFiled.getText());
			y=Integer.parseInt(yFiled.getText());
			while((x<0||x>800)&&(y<0||y>600))
			{
				JOptionPane.showMessageDialog(null, "Wrong cordinates please enter again","Error",JOptionPane.WARNING_MESSAGE);
				x=Integer.parseInt(xFiled.getText());
				y=Integer.parseInt(yFiled.getText());
			}
			type=(String)allAniaml.getSelectedItem();
			for(int i=0;i<zoo.getI();i++)
			{
				f=ZooPanel1.array.get(i).getName();
				if(f.equals(type))
				{
					i2=i;
				}
			}
			p=new Point(x,y);
			ZooPanel1.array.get(i2).setLocation(p);
			ZooPanel1.array.get(i2).setChanges(true);
			ZooPanel1.array.get(i2).getPanel().repaint();
			JOptionPane.showMessageDialog(null, "Animal moved");
			if(ZooPanel1.array.get(i2) instanceof Lion)
			{
				((Lion)ZooPanel1.array.get(i2)).dircheck(p);
			}
			if(ZooPanel1.array.get(i2) instanceof Bear)
			{
				((Bear)ZooPanel1.array.get(i2)).dircheck(p);
			}
			if(ZooPanel1.array.get(i2) instanceof Giraffe)
			{
				((Giraffe)ZooPanel1.array.get(i2)).dircheck(p);
			}
			if(ZooPanel1.array.get(i2) instanceof Elephant)
			{
				((Elephant)ZooPanel1.array.get(i2)).dircheck(p);
			}
			if(ZooPanel1.array.get(i2) instanceof Turtle)
			{
				((Turtle)ZooPanel1.array.get(i2)).dircheck(p);
			}
			zoo.manageZoo();
			dispose();
		}
	}
}
