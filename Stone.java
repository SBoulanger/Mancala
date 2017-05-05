
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Stone 
{
	//pebble draws itself
	public void draw(Graphics2D g2, int x, int y, int colorInput)
	{
		Ellipse2D stone = new Ellipse2D.Double(x, y, 30, 30);
		
		Random rand = new Random();
		int colorInt = rand.nextInt(9);
		
		Color color = null;
		
		switch(colorInput)
		{
			case 0: color = Color.BLUE; break;
			case 1: color = Color.RED; break;
			case 2: color = Color.YELLOW; break;
			case 3: color = Color.black; break;
			
			
			
		}
		
		
	    g2.setColor(color);
		g2.draw(stone);
		g2.fill(stone);

	}
}
