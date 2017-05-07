import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
* @author Samuel Boulanger
* @author Cindy Ho
* @author Aldo Barrientos
* Mancala class representing the Mancala holes
*/
 class Mancala extends Hole 
 {
	
	private int pebbleX;
	private int pebbleY;
	private final int width = 120;
	private final int height = 360;

	/**
	* calls the Hole (super) contructor
	* @param pebbles the amount of pebbles in Mancala
	* @param id the ID of the hole
	*/
	public Mancala(int pebbles, int id) 
	{
		super(pebbles, id);
	}

	

	/**
	* draws the all the stones in the hole
	* @param g2 2-dimensional graphics object to draw on
	* @param x coordinate
	* @param y coordinate
	*/
	public void drawStones(Graphics2D g2, int x, int y)
	{ 
		
		if (this.getStones() < 5){
			for(int i = 0; i < this.getStones(); i++)
			{
				translatePebble(x, y, i);
				Stone pebble = new Stone();
				pebble.draw(g2, pebbleX, pebbleY, i);
			}
		}
		else
		{	
			Font Title = new Font("Arial", Font.PLAIN, 50);
		 	g2.setFont(Title);
		 	g2.setColor(Color.black);
			g2.drawString(this.getStones() + "", x + 45, y + 180);
		}
	}

	/**
	* translates the pebble to be drawn
	* @param x position
	* @param y position
	* @param z pebble count
	*/
	public void translatePebble(int x, int y, int z)
	{
		this.pebbleX = (int) (Math.cos(z * 3.14f / 2 - 3.14f / 2) * 30 + (x + 50)); 
		this.pebbleY = (int) (Math.sin(z * 3.14f / 2 - 3.14f / 2) * 30 + (y + 180));	
	}

	/**
	* returns the width of mancala hole
	* @return the width integer
	*/
	public int getWidth(){
		return this.width;
	}

	/**
	* returns the height of mancala hole
	* @return the height integer
	*/
	public int getHeight(){
		return this.height;
	}
 }
