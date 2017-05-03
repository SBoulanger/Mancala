import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import java.awt.Component;
import java.awt.Graphics;
import java.lang.Cloneable;
import java.lang.CloneNotSupportedException;

abstract class Hole implements Cloneable
{

	private int x;
	private int y;
	private int pebbles;
	private int pebbleX;
	private int pebbleY;
	private int arrPos;
	
	int[][] holePos = new int[14][2];

	
	public Hole(int pebbles, int arrPos)
	{
		this.pebbles = pebbles;
		this.arrPos = arrPos;
	}
	
	
	public int getArrPos()
	{
		return arrPos;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	//move the x/y pos. of pebbles
	public void translatePebble(int x, int y, int z)
	{
		
	}
	
	public void addListener()
	{
		
	}

	public Hole clone(){
		try {
			Hole hole = (Hole)super.clone();
			return hole;
		} catch (CloneNotSupportedException e){
			return null;
		}
	}
	
	
	public void setStones(int pebbles)
	{
		this.pebbles = pebbles;
	}
	
	public int getStones()
	{
		return pebbles;
	}
	
	public boolean contains(int x, int y)
	{
		if (x > this.x && x < this.x + 120 && y > this.y && y < this.y + 120){
			return true;
		}
		return false;
	}
	
	abstract public void draw(Graphics2D g2, int x, int y);
	abstract public void drawStones(Graphics2D g2, int x, int y);

}
