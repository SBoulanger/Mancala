import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
* Rectangle Layout for Mancala Board
*/
public class RectangleBoard implements BoardLayout
{
	private ArrayList<Hole> holes;

	private final int BORDER = 50;
	private final int ROWAY = 450;
	private final int ROWBY = 50;
	private final int MANCALAY = 120;
	private final int HOLEGAP = 10;

	private final double HEIGHT = 600.0;
	private final double WIDTH  = 1200.0;

	/**
	* Constructor that initializes the Layout and stores the holes array
	* @param the list of mancala holes
	*/
	public RectangleBoard(ArrayList<Hole> holes)
	{
		this.holes = holes;
	}
	
	/**
	* Calls the drawBoard algorithm
	* @param the paint component
	* @param the graphics object to draw on
	* @param the x coordinate
	* @param the y coordinate
	*/
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		drawBoard((Graphics2D) g);
	}
	/**
	* drawing algorithm that draws the rectangle board
	* @param 2-dimensional graphics object used to draw shapes on
	*/
	public void drawBoard(Graphics2D g2){

		//set board color
		Color color1 = new Color(163, 123, 80);
		g2.setColor(color1);
		//create the rectangle board
		Rectangle2D board = new Rectangle2D.Double(10.0,10.0,WIDTH,HEIGHT);
		g2.draw(board);
		g2.fill(board);

		//set the hole color
		Color color2 = new Color(145, 107, 66);
		g2.setColor(color2);

		//set mancala positions
		this.holes.get(DataModel.mancalaBPosition).draw(g2,BORDER,MANCALAY);

		int mancalaAx = (int)WIDTH - BORDER - this.holes.get(DataModel.mancalaAPosition).getWidth();
		this.holes.get(DataModel.mancalaAPosition).draw(g2,mancalaAx,MANCALAY);

		//A's
		int xo = BORDER + this.holes.get(DataModel.mancalaAPosition).getWidth();
		for (int i = this.holes.size()/2 + 1; i < this.holes.size();i++){ 
			
			xo = xo + HOLEGAP;
			this.holes.get(i).draw(g2,xo,ROWAY);			
			xo = xo + this.holes.get(i).getWidth() + HOLEGAP;
		}
		//B's
		xo = xo - this.holes.get(DataModel.mancalaBPosition).getWidth();
		for (int i = 1; i < this.holes.size()/2;i++){
			xo = xo - HOLEGAP;
			this.holes.get(i).draw(g2,xo,ROWBY);
			xo = xo - this.holes.get(i).getWidth() - HOLEGAP;
		}

		//set and draw the labels
		Font Labels = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(Labels);
		g2.setColor(Color.RED);

		g2.drawString("B", 20, (int)HEIGHT/2);
		g2.drawString("A", 1170, (int)HEIGHT/2);

		String [] sideA = {"A1", "A2", "A3", "A4", "A5", "A6", ""};
		String [] sideB = {"B1", "B2", "B3", "B4", "B5", "B6", ""};

		int stringX = BORDER + HOLEGAP + HOLEGAP;
		for(int j = 6; j > -1; j--){ 
			g2.drawString(sideB[j], stringX, 230);
			stringX += HOLEGAP + this.holes.get(1).getWidth();
		}

		stringX = 270;
		for(int j = 0; j < 7; j++){
			g2.drawString(sideA[j], stringX, 390);
			stringX += HOLEGAP + this.holes.get(1).getWidth();
		}
	}

	/**
	* returns the width of board
	* @return the board width as an integer
	*/
	public 	int getIconWidth() 
	{
		return (int)this.WIDTH;
	}
	/**
	* returns the heigth of board
	* @return the board height as an integer
	*/
	public int getIconHeight() 
	{
		return (int)this.HEIGHT;
	}
}
