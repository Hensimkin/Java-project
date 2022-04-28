package diet;

import animal.Animal;
import food.EFoodType;
import food.IEdible;
/**
 * a class the that represent a carnivore and impements IDiet
 * @author Hen simkin 
 * @author Adir melker
 */
public class Carnivore implements IDiet
{
	/**
	 * function that check if he can eat this type of food
	 * @param food
	 * 			type of food
	 * @return
	 * 		if he can eat this type of food he return true else false
	 */
	public boolean canEat(EFoodType food)
	{
		if (food.equals(EFoodType.MEAT))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * function that first check if he can eat this type of food and if he can she increase is weight
	 * @param animal			
	 * 			what type of animal
	 * @param food
	 * 			what type of food
	 * @return 
	 * 		return is update weight if he can eat,else return 0;
	 */
	public double eat(Animal animal, IEdible food)
	{
		if(canEat(food.getFoodtype())==true)
		{
			double temp1=animal.getWeight();
			double tempweight=temp1+temp1*0.1;
			return tempweight;
		}
		else
		{
			return 0;
		}
	}
	
	
	 public String toString()
	    {
	        return "[Carnivore]";
	    }

}
