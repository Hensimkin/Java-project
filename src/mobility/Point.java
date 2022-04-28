package mobility;

/**
 * class that represent a point in the location
 * @author Hen simkin 
 * @author Adir melker
 */
public class Point 
{

	private int x;
	private int y;
	private static final int max_x=800;
	private static final int max_y=600;
	
	public Point()
	{
		x=0;
		y=0;
	}
	
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Point(Point p)
	{
		this.x=p.getX();
		this.y=p.getY();
	}
	
	/**
	 * set x is need to be between 0 to 800
	 * @param x
	 * 		the x paramenter
	 * @return	
	 * 		true if x between 0 to 800
	 */
	public boolean setX(int x)
	{
		if (x>=0&&x<=max_x)
		{
			this.x=x;
			return true;
		}
		else
		{
			System.out.print("Please enter valid x");
			return false;
		}
	}
	/**
	 * set y is need to be between 0 to 600
	 * @param y
	 * 		the y paramenter
	 * @return	
	 * 		true if y between 0 to 600
	 */
	public boolean setY(int y)
	{
		if (y>=0&&y<=max_y)
		{
			this.y=y;
			return true;
		}
		else
		{
			System.out.print("Please enter valid Y");
			return false;
		}	
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * check if point is in the boundries - 0<=x<=800 and 0<=y<=600
	 * @param p
	 * 		the point we check
	 * @return
	 * 		true if the point is inside the boundries else return false
	 */
	public static boolean cheackBounderies(Point p)
	{
		if ((p.getX()>=0 && p.getX()<=max_x)&&(p.getY()>=0 && p.getY()<=max_y))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public  String toString()
	{
		return String.format("%d,%d",this.getX(),this.getY());
	}
	
	
	public boolean checkx(Point p)
	{
		if(this.x>p.getX())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checky(Point p)
	{
		if(this.y>p.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}


