package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import animal.*;
import factory.AbstractFactory;
import factory.FactoryProducer;

/**
 * The class that take care of add animal option
 * @author Adir Melker 316614569 and Hen Simkin 208514109
 *
 */
public class AddAnimalDialog extends JDialog implements ActionListener
{
	JLabel animalt;
	Animal object;
	JComboBox list;
	JComboBox hor;
	JComboBox ver;
	JComboBox color;
	JButton button;
	JTextField field;
	String type="NoString";
	int num1=0,num2=0,size;
	String c="NoString";
    static int i=0;
    ImageIcon animal;
    static int lionc=1,bearc=1,elephantc=1,giraffec=1,turtlec=1;
    String name;
    ZooPanel1 zoo;
	private String st;



	private AbstractFactory animalfactory;
	/**
	 * Default Contractor that add buttons to the panel 
	 */
	public AddAnimalDialog(ZooPanel1 zoo,ZooFrame frame,String s)
	{
		super(frame,"Add animal",true);
		this.st=s;
		button=new JButton("Accept");
		button.addActionListener(this);
		JLabel label=new JLabel("Choose animal");
		JLabel label2=new JLabel("Choose Horizontal speed");
		JLabel label3=new JLabel("Choose Vertical speed");
		JLabel label4=new JLabel("Enter size of animal 50-300");
		JLabel label5=new JLabel("Select the color of the animal");
		JLabel label6=new JLabel("Press to Finish");
		Integer numbers[]= {1,2,3,4,5,6,7,8,9,10};
		Integer numbers2[]= {1,2,3,4,5,6,7,8,9,10};
		String carnivore[]= {"Lion"};
		String omnivore[]={"Bear"};
		String herbivore[]={"Elephant","Giraffe","Turtle"};
		String animals[]= {"Lion","Bear","Elephant","Giraffe","Turtle"};
		String colors[]= {"Natural","Blue","Red"};
		this.setLayout(new GridLayout(6,1));
		this.setSize(400,200);
		//this.setVisible(true);
		//this.setTitle("Add Animal");
		//new Animsec(zoo);
		if (s=="carnivore")
		{
			list=new JComboBox(carnivore);
		}
		if(s=="herbivore")
		{
			list=new JComboBox(herbivore);
		}
		if(s=="omnivore")
		{
			list=new JComboBox(omnivore);
		}
		hor=new JComboBox(numbers);
		ver=new JComboBox(numbers2);
		list.addActionListener(this);
		color=new JComboBox(colors);
		field=new JTextField();
		this.add(label);
		this.add(list);
		list.addActionListener(this);
		this.add(label2);
		this.add(hor);
		hor.addActionListener(this);
		this.add(label3);
		this.add(ver);
		ver.addActionListener(this);
		this.add(label4);
		this.add(field);
		field.addActionListener(this);
		this.add(label5);
		this.add(color);
		color.addActionListener(this);
		this.add(label6);
		this.add(button);
		this.zoo=zoo;
		this.setVisible(true);

	}

	/**
	 * check what the user select (which animal,horizontal and vertical speed,size color) 
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==list)
		{
			if(list.getSelectedItem()=="Lion")
			{
				type="Lion";
			}
			
			if(list.getSelectedItem()=="Bear")
			{
				type="Bear";
			}
			if(list.getSelectedItem()=="Elephant")
			{
				type="Elephant";
			}
			if(list.getSelectedItem()=="Giraffe")
			{
				type="Giraffe";
			}
			if(list.getSelectedItem()=="Turtle")
			{
				type="Turtle";
			}
			
		}
		if(e.getSource()==hor)
		{
			num1=(int) hor.getSelectedItem();
		}
		if(e.getSource()==ver)
		{
			num2=(int) ver.getSelectedItem();
		}
		/*
		if(e.getSource()==field)
		{
			
			int input=Integer.parseInt(field.getText());
			size=input;
		}
		*/
		if(e.getSource()==color)
		{
			if(color.getSelectedItem()=="Blue")
			{
			   c="Blue";
			}
			if(color.getSelectedItem()=="Red")
			{
			   c="Red";
			}
			if(color.getSelectedItem()=="Natural")
			{
			   c="Natural";
			}
		}
		if(e.getSource()==button)
		{
			if(num1==0||num2==0||type=="NoString"||c=="NoString")
			{
				JOptionPane.showMessageDialog(null, "Please enter the missing details !!");
			}
			else
			{
				size=Integer.parseInt(field.getText());
				if(size<50||size>300) 
				{
					JOptionPane.showMessageDialog(null, "Size must be between 50 and 300");
				}
				else
				{
					if(zoo.getI()<2)
					{
						if(st=="carnivore")
						{
							name="Lion"+lionc;
							lionc++;
							this.animalfactory= FactoryProducer.getFactory(st);
							object= animalfactory.getAnimal("Lion",name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*0.8));

						}
						if(st=="omnivore")
						{
							name="Bear"+bearc;
							bearc++;
							this.animalfactory= FactoryProducer.getFactory(st);
							object= animalfactory.getAnimal("Bear",name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*1.5));
						}
						if(st=="herbivore")
						{
							if(type=="Elephant")
							{
								name="Elephant"+elephantc;
								elephantc++;
								this.animalfactory= FactoryProducer.getFactory(st);
								object= animalfactory.getAnimal("Elephant",name,(int)size,c,num1,num2,zoo);
								object.setWeight((int) (size*10));
							}
							if(type=="Giraffe")
							{
								name="Giraffe"+giraffec;
								giraffec++;
								this.animalfactory= FactoryProducer.getFactory(st);
								object= animalfactory.getAnimal("Giraffe",name,(int)size,c,num1,num2,zoo);
								object.setWeight((int) (size*2.2));
							}
							if(type=="Turtle")
							{
								name="Turtle"+turtlec;
								turtlec++;
								this.animalfactory= FactoryProducer.getFactory(st);
								object= animalfactory.getAnimal("Turtle",name,(int)size,c,num1,num2,zoo);
								object.setWeight((int) (size*0.5));
							}
						}
						/*
						if(type=="Lion")
						{
							name="Lion"+lionc;
							lionc++;
							//MoveAnimalDialog.allAniaml.addItem(name);
							//size=(int) (size*0.8);

							object=new Lion(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*0.8));
							ZooPanel1.array.add(object);
							//object.getThread().start();
							//ZooPanel1.array.get(0).getPanel().manageZoo();
							ZooPanel1.data[zoo.getI()][0]=name;
							ZooPanel1.data[zoo.getI()][1]=c;
							ZooPanel1.data[zoo.getI()][2]=object.getWeight();
							ZooPanel1.data[zoo.getI()][3]=num1;
							ZooPanel1.data[zoo.getI()][4]=num2;
							ZooPanel1.data[zoo.getI()][5]=object.getEatCount();
							zoo.updatei(1);
							zoo.updatetrd(object);


						}


						if(type=="Bear")
						{
							name="Bear"+bearc;
							bearc++;
							//MoveAnimalDialog.allAniaml.addItem(name);
							size=(int) (size*1.5);
							object=new Bear(name,(int)size,c,num1,num2,zoo);
							ZooPanel1.array.add(object);
							//object.getThread().start();
							object.setWeight((int) (size*1.5));
							//ZooPanel1.array.get(0).getPanel().manageZoo();
							ZooPanel1.data[zoo.getI()][0]=name;
							ZooPanel1.data[zoo.getI()][1]=c;
							ZooPanel1.data[zoo.getI()][2]=object.getWeight();
							ZooPanel1.data[zoo.getI()][3]=num1;
							ZooPanel1.data[zoo.getI()][4]=num2;
							ZooPanel1.data[zoo.getI()][5]=object.getEatCount();
							zoo.updatei(1);
							zoo.updatetrd(object);
						}
						if(type=="Elephant")
						{
							name="Elephant"+elephantc;
							elephantc++;
							//MoveAnimalDialog.allAniaml.addItem(name);
							//size=(int) (size*10);
							object=new Elephant(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*10));
							ZooPanel1.array.add(object);
							//object.getThread().start();
							//ZooPanel1.array.get(0).getPanel().manageZoo();
							ZooPanel1.data[zoo.getI()][0]=name;
							ZooPanel1.data[zoo.getI()][1]=c;
							ZooPanel1.data[zoo.getI()][2]=object.getWeight();
							ZooPanel1.data[zoo.getI()][3]=num1;
							ZooPanel1.data[zoo.getI()][4]=num2;
							ZooPanel1.data[zoo.getI()][5]=object.getEatCount();
							zoo.updatei(1);
							zoo.updatetrd(object);
						}
						if(type=="Giraffe")
						{
							name="Giraffe"+giraffec;
							giraffec++;
							//MoveAnimalDialog.allAniaml.addItem(name);
							size=(int) (size*2.2);
							object=new Giraffe(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*2.2));
							ZooPanel1.array.add(object);
							//object.getThread().start();
							//ZooPanel1.array.get(0).getPanel().manageZoo();
							ZooPanel1.data[zoo.getI()][0]=name;
							ZooPanel1.data[zoo.getI()][1]=c;
							ZooPanel1.data[zoo.getI()][2]=object.getWeight();
							ZooPanel1.data[zoo.getI()][3]=num1;
							ZooPanel1.data[zoo.getI()][4]=num2;
							ZooPanel1.data[zoo.getI()][5]=object.getEatCount();
							zoo.updatei(1);
							zoo.updatetrd(object);
						}
						if(type=="Turtle")
						{
							name="Turtle"+turtlec;
							turtlec++;
							//MoveAnimalDialog.allAniaml.addItem(name);
							//size=(int) (size*0.5);
							object=new Turtle(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*0.5));
							ZooPanel1.array.add(object);
							//object.getThread().start();
							//ZooPanel1.array.get(0).getPanel().manageZoo();
							ZooPanel1.data[zoo.getI()][0]=name;
							ZooPanel1.data[zoo.getI()][1]=c;
							ZooPanel1.data[zoo.getI()][2]=object.getWeight();
							ZooPanel1.data[zoo.getI()][3]=num1;
							ZooPanel1.data[zoo.getI()][4]=num2;
							ZooPanel1.data[zoo.getI()][5]=object.getEatCount();
							zoo.updatei(1);
							zoo.updatetrd(object);


						}

						 */
						ZooPanel1.array.add(object);
						ZooPanel1.data[zoo.getI()][0]=name;
						ZooPanel1.data[zoo.getI()][1]=c;
						ZooPanel1.data[zoo.getI()][2]=object.getWeight();
						ZooPanel1.data[zoo.getI()][3]=num1;
						ZooPanel1.data[zoo.getI()][4]=num2;
						ZooPanel1.data[zoo.getI()][5]=object.getEatCount();
						zoo.updatei(1);
						zoo.updatetrd(object);
						JOptionPane.showMessageDialog(null, "Animal added");
						zoo.manageZoo();
						dispose();
					}
					else
					{
						if(st=="carnivore")
						{
							name="Lion"+lionc;
							lionc++;
							this.animalfactory= FactoryProducer.getFactory(st);
							object= animalfactory.getAnimal("Lion",name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*0.8));

						}
						if(st=="omnivore")
						{
							name="Bear"+bearc;
							bearc++;
							this.animalfactory= FactoryProducer.getFactory(st);
							object= animalfactory.getAnimal("Bear",name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*1.5));
						}
						if(st=="herbivore")
						{
							if(type=="Elephant")
							{
								name="Elephant"+elephantc;
								elephantc++;
								this.animalfactory= FactoryProducer.getFactory(st);
								object= animalfactory.getAnimal("Elephant",name,(int)size,c,num1,num2,zoo);
								object.setWeight((int) (size*10));
							}
							if(type=="Giraffe")
							{
								name="Giraffe"+giraffec;
								giraffec++;
								this.animalfactory= FactoryProducer.getFactory(st);
								object= animalfactory.getAnimal("Giraffe",name,(int)size,c,num1,num2,zoo);
								object.setWeight((int) (size*2.2));
							}
							if(type=="Turtle")
							{
								name="Turtle"+turtlec;
								turtlec++;
								this.animalfactory= FactoryProducer.getFactory(st);
								object= animalfactory.getAnimal("Turtle",name,(int)size,c,num1,num2,zoo);
								object.setWeight((int) (size*0.5));
							}
						}
						/*
						if(type=="Lion")
						{
							name = "Lion" + lionc;
							lionc++;
							object = new Lion(name, (int) size, c, num1, num2, zoo);
							object.setWeight((int) (size * 0.8));
							zoo.updatetrd(object);
							zoo.addanimal(object);
						}
						if(type=="Bear")
						{
							name="Bear"+bearc;
							bearc++;
							size=(int) (size*1.5);
							object=new Bear(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*1.5));
							zoo.updatetrd(object);
							zoo.addanimal(object);
						}
						if(type=="Elephant")
						{
							name="Elephant"+elephantc;
							elephantc++;
							object=new Elephant(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*10));
							zoo.updatetrd(object);
							zoo.addanimal(object);
						}
						if(type=="Giraffe")
						{
							name="Giraffe"+giraffec;
							giraffec++;
							size=(int) (size*2.2);
							object=new Giraffe(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*2.2));
							zoo.updatetrd(object);
							zoo.addanimal(object);
						}
						if(type=="Turtle")
						{
							name="Turtle"+turtlec;
							turtlec++;
							object=new Turtle(name,(int)size,c,num1,num2,zoo);
							object.setWeight((int) (size*0.5));
							zoo.updatetrd(object);
							zoo.addanimal(object);
						}

						 */
						zoo.updatetrd(object);
						zoo.addanimal(object);
						JOptionPane.showMessageDialog(null, "Animal added");
						zoo.manageZoo();
						dispose();
					}
				}
			}
		}
	}
	
	/*
	public Animal getAnimal()
	{
		return object;
	}
	*/
}
