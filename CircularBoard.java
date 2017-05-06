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

public class CircularBoard implements BoardLayout
{
	private DataModel model;
	private ArrayList<Hole> holes;
	private int pebbles;
	private int holeX = 150;
	private int holeY = 50;

	private final double HEIGHT = 580.0;
	private final double WIDTH  = 1180.0;
	
	public CircularBoard(ArrayList<Hole> holes)
	{

		this.holes = holes;
		
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		drawBoard((Graphics2D) g);
	}

	public void drawBoard(Graphics2D g2){
		Color color1 = new Color(163, 123, 80);
		g2.setColor(color1);
		Ellipse2D board = new Ellipse2D.Double(10.0,10.0, WIDTH, HEIGHT);
		g2.draw(board);
		g2.fill(board);
		this.holes.get(0).setX(980);
		this.holes.get(0).setY(120);
		this.holes.get(0).draw(g2, 980, 120);
		this.holes.get(7).setX(100);
		this.holes.get(7).setY(120);
		this.holes.get(7).draw(g2, 100, 120);

		int holex = 220;
		int [] holey2 = {0, 80, 40, 20, 20, 40, 80};
		int [] holey1 = {0, 400, 440, 460, 460, 440, 400};

		for (int i = 1; i < holes.size()/2;i++){
			this.holes.get(i + 7).setX(holex);
			this.holes.get(i + 7).setY(holey1[i]);
			this.holes.get(i + 7).draw(g2, holex, holey1[i]);
			holex += 130;
		}

		holex = 865;
		for (int i = 1; i < holes.size()/2 ;i++){
			this.holes.get(i).setX(holex);
			this.holes.get(i).setY(holey2[i]);
			this.holes.get(i).draw(g2, holex, holey2[i]);
			holex -= 130;
		}

		Font Labels = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(Labels);
		g2.setColor(Color.RED);

		g2.drawString("B", 80, 300);
		g2.drawString("A", 1110, 300);

		String [] sideB = {"A1", "A2", "A3", "A4", "A5", "A6", ""};
		String [] sideA = {"B1", "B2", "B3", "B4", "B5", "B6", ""};
		int stringX = 135;
		for(int i = 6; i > -1; i--){
			g2.drawString(sideA[i], stringX, 230);
			stringX += 130;
		}

		stringX = 270;;
		for(int i = 0; i < 7; i++){
			g2.drawString(sideB[i], stringX, 390);
			stringX += 130;
		}
	}

	public 	int getIconWidth() 
	{
		return (int)this.WIDTH;
	}

	public int getIconHeight() 
	{
		return (int)this.HEIGHT;
	}
}
