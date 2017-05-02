import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

class Mancala extends Hole 
 {

	public Mancala(int pebbles, int id) 
	{
		
		super(pebbles, id);
		
	}
	    public void draw(Graphics2D g2, int x, int y){
		Ellipse2D hole = new Ellipse2D.Double(x, y, 120, 360);
        g2.draw(hole);
	}
 }
