package Mancala;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Stone 
{
	//pebble draws itself
	public void draw(Graphics2D g2, int x, int y)
	{
		Ellipse2D stone = new Ellipse2D.Double(x, y, 30, 30);
		g2.fill(stone);
		g2.draw(stone);

	}
}
