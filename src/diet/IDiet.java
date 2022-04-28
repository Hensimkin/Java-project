package diet;

import food.*;
import animal.Animal;

/**
 * interface that represent the diet of the animal
 * @author Hen simkin 
 * @author Adir melker
 */
public interface IDiet 
{
	public boolean canEat(EFoodType food);
	public double eat(Animal animal, IEdible food);
}
