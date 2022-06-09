package mobility;
import java.lang.Math;
import java.util.Observable;

/**
 * mobile is an abstract class that implements Ilocatable that calc all the distance and location of animal
 * @author Hen simkin 
 * @author Adir melker
 */
public abstract class Mobile extends Observable implements Ilocatable
{

	private Point location;
	private double totalDistance;

	public Mobile(Point p)
	{
		this.location=new Point(p.getX(),p.getY());
		this.totalDistance=1;
	}
	
	/**
	 * add to the total distance d
	 * @param d
	 * 		the additional distance 
	 */
	public void addTotalDistance(double d)
	{
		this.totalDistance=this.totalDistance+d;
	}
	
	/**
	 * calc the distance from point p to his location
	 * @param p	
	 * 		a point
	 * @return
	 * 		the distance between the point
	 */
	public double calcDistance(Point p)
	{
		return Math.sqrt(Math.pow(this.location.getX()-p.getX(),2)+Math.pow(this.location.getY()-p.getY(),2));
	}
	
	
	public abstract double move(Point p);

	/**
	 * return the location
	 */
	public Point getLocation()
	{
		Point a=new Point(this.location.getX(),this.location.getY());
		return a;
	}
	
	/**
	 * set the location
	 */
	public boolean setLocation(Point p)
	{
		return this.location.setX(p.getX())&&this.location.setY(p.getY());
	}
	
	/**
	 * 
	 * @return the total distance
	 */
	public double getTotaldistance()
	{
		return this.totalDistance;
	}
	
	
}
