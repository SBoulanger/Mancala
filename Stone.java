
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Stone 
{
	//pebble draws itself
	public void draw(Graphics2D g2, int x, int y)
	{
		Ellipse2D stone = new Ellipse2D.Double(x, y, 30, 30);
		Random rand = new Random();
		int r = 0;; int g = 0;; int b = 0;
		r = rand.nextInt(255);
	    g = rand.nextInt(255);
	    b = rand.nextInt(255);
	    Color color = new Color(r,b,g);
	    g2.setColor(color);
		g2.fill(stone);
		g2.draw(stone);

	}
}
