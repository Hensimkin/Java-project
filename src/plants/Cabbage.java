package plants;

import utilities.MessageUtility;

import java.awt.*;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant
{
	public Cabbage() 
	{
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}

	@Override
	public void loadImages(String nm) {

	}

	@Override
	public void drawObject(Graphics g) {

	}

	@Override
	public String getColor() {
		return null;
	}
}
