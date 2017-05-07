import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.lang.Cloneable;
import java.lang.CloneNotSupportedException;

/**
* @author Samuel Boulanger
* @author Cindy Ho
* @author Aldo Barrientos
* Abstract class that defines the general holes in a Mancala game
*/
abstract class Hole implements Cloneable
{

	private int x;
	private int y;
	private int pebbles;
	protected int pebbleX;
	protected int pebbleY;
	private int arrPos;
	
	int[][] holePos = new int[14][2];

	/**
	* Contructor that initalizes the pebble count and array position
	* @param pebbles the amount of pebbles
	* @param arrPos the index in the dataModel array
	*/
	public Hole(int pebbles, int arrPos)
	{
		this.pebbles = pebbles;
		this.arrPos = arrPos;
	}
	
	/**
	* gets the index of this hole in the dataModel array
	* @return index of position in dataModel array
	*/
	public int getArrPos()
	{
		return arrPos;
	}
	
	/**
	* sets the x position of the Hole
	* @param x the x position
	*/
	public void setX(int x)
	{
		this.x = x;
	}
	/**
	* sets the y position of the Hole
	* @param y the y position
	*/
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	* returns a clone of the hole position
	* @return the clones hole
	*/
	public Hole clone(){
		try {
			Hole hole = (Hole)super.clone();
			return hole;
		} catch (CloneNotSupportedException e){
			return null;
		}
	}
	
	/**
	* sets the pebble count in the hole
	* @param pebbles the amount of pebbles
	*/
	public void setStones(int pebbles)
	{
		this.pebbles = pebbles;
	}

	/**
	* returns the amount of pebbles in the hole
	* @return the amount of pebbles in the hole
	*/
	public int getStones()
	{
		return pebbles;
	}
	
	/**
	* checks whether an x and y coordinate is in the area of the hole
	* @param x coordinate
	* @param y coordinate
	* @return return true if in circle false otherwise
	*/
	public boolean contains(int x, int y)
	{
		if (x > this.x && x < this.x + 120 && y > this.y && y < this.y + 120){
			return true;
		}
		return false;
	}
	
	public int getPebbleX()
	{
		return pebbleX;
	}
	
	public int getPebbleY()
	{
		return pebbleY;
	}
	
	/**
	* gets the width of hole
	* @param width
	*/
	abstract public int getWidth();
	/**
	* gets the height of hole
	* @param height
	*/
	abstract public int getHeight();
	/**
	* translates the pebble to be drawn
	* @param x position
	* @param y position
	* @param z pebble count
	*/
	abstract public void translatePebble(int x, int y, int z);
	/**
	* draws the hole onto the screen
	* @param g2 2-dimensional graphics object to draw on
	* @param x coordinate
	* @param y coordinate
	*/
	public void draw(Graphics2D g2, int x, int y){
		setX(x);
		setY(y);
		Ellipse2D hole = new Ellipse2D.Double(x, y, this.getWidth(), this.getHeight());
		Color color = new Color(155, 100, 49);
		g2.setColor(color);
        g2.draw(hole);
        g2.fill(hole);
		g2.setColor(Color.BLACK);

        this.drawStones(g2, x, y);
	}
	/**
	* draws the all the stones in the hole
	* @param g2 2-dimensional graphics object to draw on
	* @param x coordinate
	* @param y coordinate
	*/
	abstract public void drawStones(Graphics2D g2, int x, int y);

}
