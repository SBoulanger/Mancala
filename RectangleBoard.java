
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
import java.awt.geom.GeneralPath;

public class RectangleBoard extends BoardLayout
{
	private DataModel model;
	private ArrayList<Hole> holes;
	private int pebbles;
	private int holeX = 150;
	private int holeY = 50;
	private final int height = 400;
	private final int width  = 1000;
	
	public RectangleBoard(ArrayList<Hole> holes)
	{
		super();

		for (int i = 0; i < holes.size()/2; i++){
			holes.get(i).setX(10+i);
			holes.get(i).setY(10+i);
			pathA.append(holes.get(i),false);
		}
	}
	
	public void translateHoles(int pos)
	{
		if(pos == 7 || pos == 0)
			return;
		
		if(pos == 6)
		{
			holeX = 150;
			holeY = 100;
			return;
		}
		
		holeX += 50;
	}

	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D board = new Rectangle2D.Double(10.0,10.0,800.0,300.0);
		g2.draw(board);
		pathA.draw(g2);
	}

	public 	int getWidth() 
	{
		return (int)this.width;
	}

	public int getHeight() 
	{
		return (int)this.height;
	}
}
