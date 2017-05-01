
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Component;
import java.awt.Graphics;


class Pit extends Hole 
{
	public Pit(int pebbles, int id) 
	{
		super(pebbles, id);
	}
	public void draw(Graphics2D g2, int x, int y){
		Ellipse2D hole = new Ellipse2D.Double(x, y, 50, 50);
        g2.draw(hole);
	}


}
