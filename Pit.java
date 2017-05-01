
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Component;
import java.awt.Graphics;


class Pit extends Hole 
{
	
	//private int pebbles;
	public Pit(int pebbles, int id) 
	{
		super(pebbles, id);
	}
	/*
	public void draw(int x, int y, Graphics2D g2)
	{
		Ellipse2D hole = new Ellipse2D.Double(x, y, 50, 50);
        g2.draw(hole);
	}
	*/
	public void paintIcon(Component c, Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D hole = new Ellipse2D.Double(getX(), getY(), 50, 50);
        g2.draw(hole);
	}
	public int getIconWidth(){
		return 10;
	}
	public int getIconHeight(){
		return 10;
	}
	public void draw(Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D hole = new Ellipse2D.Double(x, y, 50, 50);
        g2.draw(hole);
	}


}
