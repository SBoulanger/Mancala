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
	private static Graphics2D g2;
	
	public RectangleBoard(ArrayList<Hole> holes)
	{
		super();

		this.holes = holes;

	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	    	
		Graphics2D g2 = (Graphics2D) g;
		this.g2 = g2;
		Rectangle2D board = new Rectangle2D.Double(10.0,10.0,width,height);
		g2.draw(board);
		this.holes.get(0).setX(50);
		this.holes.get(0).setY(120);
		this.holes.get(0).draw(g2,50,120);

		this.holes.get(7).setY(120);
		this.holes.get(7).setX(1030);
		this.holes.get(7).draw(g2,1030,120);

		int xo = 180;
		for (int i = 1; i < this.holes.size()/2;i++){
			xo = xo + 10;
			this.holes.get(i).draw(g2,xo,450);
			this.holes.get(i).setY(450);
			this.holes.get(i).setX(xo);
			xo = xo + 120 + 10;
		}
		xo = xo - 120;
		for (int i = 8; i < this.holes.size();i++){
			xo = xo - 10;
			this.holes.get(i).setX(xo);
			this.holes.get(i).setY(50);
			this.holes.get(i).draw(g2,xo,50);
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
	
	public static void dislayWinner(Player p)
	{
		String winner = "Player A!";
		if(p == Player.PLAYERB)
			winner = "Player B!";
		
		Font Labels = new Font("Arial", Font.PLAIN, 100);
		g2.setFont(Labels);
		g2.setColor(Color.BLACK);

		g2.drawString("THE WINNER IS" + winner, 300, 500);
			
			
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
