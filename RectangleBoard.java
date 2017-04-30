
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class RectangleBoard implements Icon
{
	private DataModel model;
	private ArrayList<Hole> holes;
	private int pebbles;
	private double height = 200;
	private double width = 300;
	private int holeX = 150;
	private int holeY = 50;
	
	public RectangleBoard(DataModel model)
	{
		this.model = model;
		holes = model.getData();
		this.pebbles = pebbles;

	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
        Graphics2D g2 = (Graphics2D) g;
/*
        for(int i = 0; i < 14; i++)
        {
        	holes.get(i).drawStones(g2);
            Hole hole = new Hole(model.getHoleAmount(i), i);
            hole.draw(holeX, holeY, g2);
            translateHoles(i);
        }
        
        Ellipse2D mancalaZero = new Ellipse2D.Double(50, 50, 100, 200);
        Ellipse2D mancalaSeven = new Ellipse2D.Double(1800, 50, 100, 200);
*/

        Rectangle board = new Rectangle(0, 0, (int)width, (int)height);

        g2.draw(board);
        
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
	
	

	public 	int getIconWidth() 
	{
		return (int)this.width;
	}

	public int getIconHeight() 
	{
		return (int)this.height;
	}
}
