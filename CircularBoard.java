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

public class CircularBoard extends BoardLayout
{
	private DataModel model;
	private ArrayList<Hole> holes;
	private int pebbles;
	private int holeX = 150;
	private int holeY = 50;
	private final int height = 600;
	private final int width  = 1200;
	
	public CircularBoard(ArrayList<Hole> holes)
	{
		super();

		this.holes = holes;
		
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	    {
	    	
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D board = new Ellipse2D.Double(10.0,10.0, 1180.0, 580.0);
		g2.draw(board);

		this.holes.get(0).draw(g2, 100, 120);
		this.holes.get(7).draw(g2, 980, 120);

		int holex = 220;
		int [] holey1 = {0, 80, 40, 20, 20, 40, 80};
		int [] holey2 = {0, 400, 440, 460, 460, 440, 400};

		for (int i = 1; i < 7;i++){
			this.holes.get(i).draw(g2, holex, holey1[i]);
			holex += 130;
		}

		holex = 865;
		for (int i = 8; i < 14;i++){
			this.holes.get(i).draw(g2, holex, holey2[i-7]);
			holex -= 130;
		}

		Font Labels = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(Labels);
		g2.setColor(Color.RED);

		g2.drawString("A", 80, 300);
		g2.drawString("B", 1110, 300);

		String [] sideA = {"A1", "A2", "A3", "A4", "A5", "A6", ""};
		String [] sideB = {"B1", "B2", "B3", "B4", "B5", "B6", ""};
		int stringX = 270;
		for(int i = 0; i < 7; i++){
			g2.drawString(sideA[i], stringX, 230);
			stringX += 130;
		}

		stringX = 135;
		for(int i = 6; i > -1; i--){
			g2.drawString(sideB[i], stringX, 390);
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
