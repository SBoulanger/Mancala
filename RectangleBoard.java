package mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class RectangleBoard implements Icon
{
	private DataModel model;
	private Hole[] holes;
<<<<<<< HEAD
=======
	private int pebbles;
>>>>>>> master
	private int holeX = 150;
	private int holeY = 50;
	
	public RectangleBoard(DataModel model)
	{
		this.model = model;
		holes = model.getData();
<<<<<<< HEAD
=======
		this.pebbles = pebbles;

>>>>>>> master
	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < 14; i++)
        {
<<<<<<< HEAD
        	if(i == 7 || i == 0)
    			continue;
            Hole hole = new Hole(model.startPebbles, i);
            hole.draw(holeX, holeY, g2);
        	holes[i].drawStones(g2, holeX, holeY);
=======
        	holes[i].drawStones(g2);
            Hole hole = new Hole(model.startPebbles, i);
            hole.draw(holeX, holeY, g2);
>>>>>>> master
            translateHoles(i);
        }
        
        Ellipse2D mancalaZero = new Ellipse2D.Double(50, 50, 100, 200);
        Ellipse2D mancalaSeven = new Ellipse2D.Double(1800, 50, 100, 200);


        Rectangle board = new Rectangle(0, 0, 2000, 300);

        g2.draw(board);
        
	}
	
	public void translateHoles(int pos)
	{
<<<<<<< HEAD
=======
		if(pos == 7 || pos == 0)
			return;
>>>>>>> master
		
		if(pos == 6)
		{
			holeX = 150;
			holeY = 100;
			return;
		}
		
		holeX += 50;
	}
	
	

	public int getIconWidth() 
	{
		return 0;
	}

	public int getIconHeight() 
	{
		return 0;
	}
}
