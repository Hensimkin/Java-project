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
	public MoveAnimalDialog()
	{
		this.setLayout(new GridLayout(4,1));
		this.setSize(400,150);
		this.setVisible(true);
		this.setTitle("Move Animal");
		String[]animals=new String[AddAnimalDialog.i];
		Object ob;
		for (int i=0;i<AddAnimalDialog.i;i++)
		{
			ob=ZooPanel1.array.get(i);
			if(ob instanceof Lion)
			{
				animals[i]=ob.getClass().getSimpleName()+lionc;
				lionc++;
			}
			if(ob instanceof Bear)
			{
				animals[i]=ob.getClass().getSimpleName()+bearc;
				bearc++;
			}
			if(ob instanceof Elephant)
			{
				animals[i]=ob.getClass().getSimpleName()+elephantc;
				elephantc++;
			}
			if(ob instanceof Giraffe)
			{
				animals[i]=ob.getClass().getSimpleName()+giraffec;
				giraffec++;
			}
			if(ob instanceof Turtle)
			{
				animals[i]=ob.getClass().getSimpleName()+turtlec;
				turtlec++;
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
			for(int i=0;i<AddAnimalDialog.i;i++)
			{
				f=ZooPanel1.array.get(i).getName();
				if(f.equals(type))
				{
					p=new Point(x,y);
					ZooPanel1.array.get(i).setLocation(p);
					ZooPanel1.array.get(i).setChanges(true);
					JOptionPane.showMessageDialog(null, "Animal moved");
					if(ZooPanel1.array.get(i) instanceof Lion)
					{
						((Lion)ZooPanel1.array.get(i)).dircheck(p);
					}
					if(ZooPanel1.array.get(i) instanceof Bear)
					{
						((Bear)ZooPanel1.array.get(i)).dircheck(p);
					}
					if(ZooPanel1.array.get(i) instanceof Giraffe)
					{
						((Giraffe)ZooPanel1.array.get(i)).dircheck(p);
					}
					if(ZooPanel1.array.get(i) instanceof Elephant)
					{
						((Elephant)ZooPanel1.array.get(i)).dircheck(p);
					}
					if(ZooPanel1.array.get(i) instanceof Turtle)
					{
						((Turtle)ZooPanel1.array.get(i)).dircheck(p);
					}
					dispose();
				}
			}
		}
		
	}

}
