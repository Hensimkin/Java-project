package zoo;
import mobility.*;
import utilities.MessageUtility;
import food.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import animal.*;

/**
 * class that make a zoo-group of animal and make on them different actions
 * @author Hen simkin 
 * @author Adir melker
 */
public class ZooActions {
	
	/**
	 * make a new point that represent the location of an animal
	 * @return
	 * 		the new location- a point
	 */
	public static Point pointBuild()
	{
		Scanner scan= new Scanner(System.in);
		int x=0,y=0;
		Point p = null;
		boolean done=false;
		while(!done)
		{
			try
			{
				System.out.println("Enter x");
				x=scan.nextInt();
				System.out.println("Enter y");
				y=scan.nextInt();
				p=new Point(x,y);
				done=true;
			}
			catch(InputMismatchException e)
			{
				String str=scan.nextLine();
				System.out.println("ivaild numbers");
			}
		}
		done=false;
		while(Point.cheackBounderies(p)==false)
		{
			while(!done)
			{
				try
				{
					System.out.println("Enter x");
					x=scan.nextInt();
					System.out.println("Enter y");
					y=scan.nextInt();
					p=new Point(x,y);
					done=true;
				}
				catch(InputMismatchException e)
				{
					String str=scan.nextLine();
					System.out.println("ivaild numbers");
				}
			}
		}
		return p;
	}
	
	
	
	
	/**
	 * the function first check which class the animal belong then check if she can eat this type of food,if she can eat this the function return true else return false
	 * @param animal
	 * 			the type of animal we check
	 * @param food
	 * 			the type of food we check
	 * @return
	 * 		true if the animal can eat else return false
	 */
	public static boolean eat(Object animal, IEdible food)
	{
		/*
		if (animal instanceof Lion ||animal instanceof Bear||animal instanceof Elephant ||animal instanceof Giraffe ||animal instanceof Turtle )
		{
			if (((Animal) animal).eat(food)==true)
				return true;
		}
		*/
		if(animal instanceof Lion)
		{
			if (((Lion) animal).eat(food)==true)
				return true;
		}
		if(animal instanceof Bear)
		{
			if (((Bear) animal).eat(food)==true)
				return true;
		}
		if(animal instanceof Elephant)
		{
			if (((Elephant) animal).eat(food)==true)
				return true;
		}
		if(animal instanceof Giraffe)
		{
			if (((Giraffe) animal).eat(food)==true)
				return true;
		}
		if(animal instanceof Turtle)
		{
			if (((Turtle) animal).eat(food)==true)
				return true;
		}
		return false;
	}
	
	/**
	 * the function first check which class the animal belong then check if the given point is legal
	 * if both condition are true we calc the distance between the new location to the old and update the total distance.
	 * after all the conditions executed the function return true
	 * @param animal
	 * 			type of animal
	 * @param point
	 * 			a location
	 * @return
	 * 		true if all the conditions executed else return false
	 */
	public static boolean move(Object animal, Point point)
	{
		/*
		if (animal instanceof Lion ||animal instanceof Bear||animal instanceof Elephant ||animal instanceof Giraffe ||animal instanceof Turtle )
		{
			if (Point.cheackBounderies(point) ==true)
			{
				double temp=((Animal)animal).getTotaldistance();
				double temp2=((Animal)animal).move(point);
				if(temp!= temp2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		*/
		if (animal instanceof Lion)
		{
			if (Point.cheackBounderies(point) ==true)
			{
				double temp=((Lion)animal).getTotaldistance();
				double temp2=((Lion)animal).move(point);
				if(temp!= temp2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		if (animal instanceof Bear)
		{
			if (Point.cheackBounderies(point) ==true)
			{
				double temp=((Bear)animal).getTotaldistance();
				double temp2=((Bear)animal).move(point);
				if(temp!= temp2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		if (animal instanceof Elephant)
		{
			if (Point.cheackBounderies(point) ==true)
			{
				double temp=((Elephant)animal).getTotaldistance();
				double temp2=((Elephant)animal).move(point);
				if(temp!= temp2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		if (animal instanceof Giraffe)
		{
			if (Point.cheackBounderies(point) ==true)
			{
				double temp=((Giraffe)animal).getTotaldistance();
				double temp2=((Giraffe)animal).move(point);
				if(temp!= temp2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		if (animal instanceof Turtle)
		{
			if (Point.cheackBounderies(point) ==true)
			{
				double temp=((Turtle)animal).getTotaldistance();
				double temp2=((Turtle)animal).move(point);
				if(temp!= temp2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * the main function of zoo , initialize a least 3 animal at the zoo depend the input by the user
	 * when insert an animal the user need to give name to the animal then choose if to give her starting point
	 * there is exception check of the input of the user all over the function to prevent error.
	 * @param args
	 */
	public static void main(String[] args)
	{
		int op1=0,op2=0;
		Random check=new Random();
		Random check2=new Random();
		int size=0;
		int temp;
		String name;
		Animal array[];
		Scanner scan= new Scanner(System.in);
		boolean done=false;
		while(!done)
		{
			try
			{
				while(size<3)
				{
					System.out.println("enter number above 3");
					size=scan.nextInt();
				}
				done=true;
			}
			catch(InputMismatchException e)
			{
				String str=scan.nextLine();
				System.out.println("ivaild");
			}
		}
		array=new Animal[size];
		for(int i=0;i<size;i++)
		{
			int option=0;
			System.out.println("enter name\n");
			name=scan.next();
			while(name.matches(".*\\d.*"))
			{
				System.out.println("enter name\n");
				name=scan.next();
			}
			System.out.println("Please select an animal\n");
			System.out.println("1. Lion \n2. Bear\n3. Elephant\n4. Giraffe\n5. Turtle\n");
			done=false;
			while(!done)
			{
				try
				{
					while(option <1||option >5)
					{
						System.out.println("enter the option\n");
						option=scan.nextInt();
					}
					done=true;
				}
				catch(InputMismatchException e)
				{
					String str=scan.nextLine();
					System.out.println("ivaild choice");
				}
			}
			array[i]=Animalbuild(name,option);
		}
		
		
		System.out.println("******Movment simulation******");
		
		for(int i=0;i<size;i++)
		{
			System.out.println("enter the point");
			if(move(array[i],pointBuild())==true)
			{
				MessageUtility.logBooleanFunction(array[i].getName(), "move()", array[i].getLocation(), true);
				System.out.print(array[i].getTotaldistance());
				System.out.println("\n");
			}
			else
			{
				MessageUtility.logBooleanFunction(array[i].getName(), "move()", array[i].getLocation(), false);
			}
		
		}
		if(size%2==0)
			temp=size/2;
		else
		{
			temp=(size-1)/2;
		}
		System.out.println("******Eating simulation******");
		for(int i=0;i<temp;i++)
		{
			while(op1==op2)
			{
				op1=check.nextInt(size);
				op2=check2.nextInt(size);
			}
			boolean t=eat(array[op1],array[op2]);
			if(t==true)
			{
				System.out.println(array[op1]+" eats "+array[op2]);
				MessageUtility.logBooleanFunction(array[op1].getName(), "eat()", array[op1].getFoodtype(), true);
			}
			else
			{
				System.out.println(array[op1]+" eats "+array[op2]);
				MessageUtility.logBooleanFunction(array[op1].getName(), "eat()", array[op1].getFoodtype(), false);
			}
		}
	}
	
	
	/**
	 * this function create new animal also can make start point to the animal if the user want.
	 * @param name
	 * 			the name of the animal
	 * @param option
	 * 			the input by the user this check which animal to create.
	 * @return
	 * 		the new animal
	 */
	public static Animal Animalbuild(String name,int option)
	{
		Scanner scan= new Scanner(System.in);
		int option2=0;
		System.out.println("Do you want to choose start point ?\n1. Yes\n2. No\n");
		boolean done=false;
		while(!done)
		{
			try
			{
				while(option2 <1||option2 >2)
				{
					System.out.println("enter the option");
					option2=scan.nextInt();
				}
				done=true;
			}
			catch(InputMismatchException e)
			{
				String str=scan.nextLine();
				System.out.println("ivaild choice");
			}
		}
		if (option2==2)
		{
			
			if (option==1)
			{
				return new Lion(name);
			}
			else if(option==2)
			{
				return new Bear(name);
			}
			else if (option==3)
			{
				return new Elephant(name);
			}
			else if (option==4)
			{
				return new Giraffe(name);
			}
			else
			{
				return new Turtle(name);
			}
			
		}
		else
		{
			if (option==1)
			{
				Point p=pointBuild();
				return new Lion(name,p);
			}
			else if(option==2)
			{
				Point p=pointBuild();
				return new Bear(name,p);
			}
			else if (option==3)
			{
				Point p=pointBuild();
				return new Elephant(name,p);
			}
			else if (option==4)
			{
				Point p=pointBuild();
				return new Giraffe(name,p);
			}
			else
			{
				Point p=pointBuild();
				return new Turtle(name,p);
			}
		}
	}
}		
