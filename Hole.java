
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

class Hole 
{

	private int pebbles;
	private int pebbleX;
	private int pebbleY;
	private int arrPos;
	
	int[][] holePos = new int[14][2]; //initialize to actual drawn positions

	
	public Hole(int pebbles, int arrPos)
	{
		this.pebbles = pebbles;
		this.arrPos = arrPos;
		setCords();
	}
	
	public void drawStones(Graphics2D g2)
	{
		for(int i = 0; i < pebbles; i++)
		{
			translatePebble();
			Stone pebble = new Stone();
			pebble.draw(g2, pebbleX, pebbleY);
		}

	}
	
	public int getArrPos()
	{
		return arrPos;
	}
	
	public void setCords()
	{
		
	}
	
	//move the x/y pos. of pebbles
	public void translatePebble()
	{
		//move around the pebbles inside the holes
		//overide depending on mancala or pit
	}
	
	public void addListener()
	{

	}
	
	public void draw(int x, int y, Graphics2D g2)
	{
		Ellipse2D hole = new Ellipse2D.Double(x, y, 50, 50);
        g2.draw(hole);
	}
	
	
	public void setStones(int pebbles)
	{
		this.pebbles = pebbles;
	}
	
	public int getStones()
	{
		return pebbles;
	}
	public boolean contains(int x, int y){
		return true;
	}

}
