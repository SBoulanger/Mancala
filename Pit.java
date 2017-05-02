
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


class Pit extends Hole 
{
	private int pebbleX;
	private int pebbleY;
	
	
	public Pit(int pebbles, int id) 
	{
		super(pebbles, id);
	}
	public void draw(Graphics2D g2, int x, int y){
		Ellipse2D hole = new Ellipse2D.Double(x, y, 120, 120);
        g2.draw(hole);
	}

	public void drawStones(Graphics2D g2, int x, int y)
	{
		this.setStones(8);
		if(this.getStones() < 5)
		{
			for(int i = 0; i < this.getStones(); i++)
			{
			
				translatePebble(x, y, i);
				Stone pebble = new Stone();
				pebble.draw(g2, pebbleX, pebbleY);	
			}
		}
		else
		{	Font Title = new Font("Arial", Font.PLAIN, 50);
		 	g2.setFont(Title);
		 	g2.setColor(Color.black);
			g2.drawString(this.getStones() + "", x + 45, y + 75);
		}
	}
	
	public void translatePebble(int x, int y, int z)
	{
		
		
		pebbleX = (int) (Math.cos(z * 3.14f / 2 - 3.14f / 2) * 30 + (x + 50)); 
		pebbleY = (int) (Math.sin(z * 3.14f / 2 - 3.14f / 2) * 30 + (y + 50));	
		
		
	}

}
