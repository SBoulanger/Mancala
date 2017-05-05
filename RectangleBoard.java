import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
		Color color1 = new Color(163, 123, 80);
		g2.setColor(color1);
		Rectangle2D board = new Rectangle2D.Double(10.0,10.0,width,height);
		g2.draw(board);
		g2.fill(board);
		Color color2 = new Color(145, 107, 66);
		g2.setColor(color2);
		this.holes.get(7).setX(50);
		this.holes.get(7).setY(120);
		this.holes.get(7).draw(g2,50,120);

		this.holes.get(0).setY(120);
		this.holes.get(0).setX(1030);
		this.holes.get(0).draw(g2,1030,120);

		int xo = 180;
		for (int i = 8; i < this.holes.size();i++){ 
			xo = xo + 10;
			this.holes.get(i).draw(g2,xo,450);
			this.holes.get(i).setY(450);
			this.holes.get(i).setX(xo);
			xo = xo + 120 + 10;
		}
		xo = xo - 120;
		for (int i = 1; i < this.holes.size()/2;i++){
			xo = xo - 10;
			this.holes.get(i).setX(xo);
			this.holes.get(i).setY(50);
			this.holes.get(i).draw(g2,xo,50);
			xo = xo - 120 - 10;
		}

		Font Labels = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(Labels);
		g2.setColor(Color.RED);

		g2.drawString("B", 20, 300);
		g2.drawString("A", 1170, 300);

		String [] sideA = {"A1", "A2", "A3", "A4", "A5", "A6", ""};
		String [] sideB = {"B1", "B2", "B3", "B4", "B5", "B6", ""};
		int stringX = 135;
		for(int j = 6; j > -1; j--){ 
			g2.drawString(sideB[j], stringX, 230);
			stringX += 130;
		}

		stringX = 270;
		for(int j = 0; j < 7; j++){
			g2.drawString(sideA[j], stringX, 390);
			stringX += 130;
		}
		
		this.g2 = g2;


	}
	
	public static void dislayWinner(Player p)
	{
		JFrame wf = new JFrame();
		 
		String winner = "PLAYER A!";
		if(p == Player.PLAYERB)
			winner = "PLAYER B!";
		
		Font Labels = new Font("Arial", Font.PLAIN, 100);
		g2.setFont(Labels);
		g2.setColor(Color.BLACK);

		System.out.println("THE WINNER IS " + winner);
		
		
		JLabel label = new JLabel("THE WINNER IS " + winner);
		wf.add(label);
		
		wf.pack();
        wf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wf.setVisible(true);		
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
