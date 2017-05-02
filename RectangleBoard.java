import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
import java.awt.geom.GeneralPath;
import java.awt.Color;
import java.awt.Font;

public class RectangleBoard extends BoardLayout
{
	private DataModel model;
	private ArrayList<Hole> holes;
	private int pebbles;
	private int holeX = 150;
	private final double height = 600.0;
	private final double width  = 1200.0;
	
	public RectangleBoard(ArrayList<Hole> holes)
	{
		super();

		this.holes = holes;

	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	    	
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D board = new Rectangle2D.Double(10.0,10.0,width,height);
		g2.draw(board);
		int i = 0;
		int xo = 50;
		this.holes.get(i).setX(xo);
		this.holes.get(i).setY(120);
		this.holes.get(i++).draw(g2,xo,120);
		xo = xo + 120 + 10;
		for (; i < this.holes.size()/2;i++){
			xo = xo + 10;
			this.holes.get(i).draw(g2,xo,50);
			this.holes.get(i).setY(50);
			this.holes.get(i).setX(xo);
			xo = xo + 120 + 10;
		}
		this.holes.get(i).setY(120);
		this.holes.get(i).setX(xo);
		this.holes.get(i++).draw(g2,xo,120);
		xo = xo - 120;
		for (; i < this.holes.size();i++){
			xo = xo - 10;
			this.holes.get(i).setX(xo);
			this.holes.get(i).setY(450);
			this.holes.get(i).draw(g2,xo,450);
			xo = xo - 120 - 10;
		}

		Font Labels = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(Labels);
		g2.setColor(Color.RED);

		g2.drawString("A", 20, 300);
		g2.drawString("B", 1170, 300);

		String [] sideA = {"A1", "A2", "A3", "A4", "A5", "A6", ""};
		String [] sideB = {"B1", "B2", "B3", "B4", "B5", "B6", ""};
		int stringX = 270;
		for(int j = 0; j < 7; j++){
			g2.drawString(sideA[j], stringX, 230);
			stringX += 130;
		}

		stringX = 135;
		for(int j = 6; j > -1; j--){
			g2.drawString(sideB[j], stringX, 390);
			stringX += 130;
		}

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
