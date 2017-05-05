import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

 class Mancala extends Hole 
 {
	
	private int pebbleX;
	private int pebbleY;

	public Mancala(int pebbles, int id) 
	{
		
		super(pebbles, id);
		
	}
	public void draw(Graphics2D g2, int x, int y){
		Ellipse2D hole = new Ellipse2D.Double(x, y, 120, 360);
		Color color2 = new Color(145, 107, 66);
		g2.setColor(color2);
        g2.draw(hole);
        g2.fill(hole);
        this.drawStones(g2, x, y);

	}
	    
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
		
	public void translatePebble(int x, int y, int z)
		{
			pebbleX = (int) (Math.cos(z * 3.14f / 2 - 3.14f / 2) * 30 + (x + 50)); 
			pebbleY = (int) (Math.sin(z * 3.14f / 2 - 3.14f / 2) * 30 + (y + 180));	
		}
 }
