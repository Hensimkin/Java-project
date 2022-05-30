package plants;

import graphics.ZooPanel1;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Lettuce extends Plant {
	private  ZooPanel1 zoo;
	BufferedImage img=null;


	private static Lettuce lettuce=null;
	public Lettuce(ZooPanel1 zoo)
	{
		super(zoo);
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	public void loadImages(String nm)
	{
		try
		{
			img = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm));
		}
		catch (IOException e)
		{
			System.out.println("Cant load picture");
		}
	}

	@Override
	public void drawObject(Graphics g)
	{
		g.drawImage(img, 400, 300, 40, 40, zoo);
	}

	@Override
	public String getColor() {
		return null;
	}


	public static Lettuce getInstance(ZooPanel1 zoo)
	{
		if(lettuce==null)
		{
			lettuce=new Lettuce(zoo);
		}
		return lettuce;
	}
}
