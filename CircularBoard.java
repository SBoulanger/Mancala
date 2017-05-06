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

/**
* Circle Layout for Mancala Board
*/
public class CircularBoard implements BoardLayout
{
	private ArrayList<Hole> holes;

	private final int DISTANCEX = 130;
	private final int ROWBY  = 120;

	private final int[] LINEAROFFYSET = {40, 80, 100, 100, 80, 40};

	private final double HEIGHT = 580.0;
	private final double WIDTH  = 1180.0;
	
	/**
	* Constructor that initializes the layout and stores the holes array
	* @param the list of mancala holes
	*/
	public CircularBoard(ArrayList<Hole> holes)
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
	* the drawing algorithm that draws the circles board
	* @param 2-dimensional graphics object used to draw shapes on
	*/
	public void drawBoard(Graphics2D g2){
		//set the color of the board
		Color color1 = new Color(163, 123, 80);
		g2.setColor(color1);

		//draw the board
		Ellipse2D board = new Ellipse2D.Double(10.0,10.0, WIDTH, HEIGHT);
		g2.draw(board);
		g2.fill(board);

		//set the mancala positions
		this.holes.get(DataModel.mancalaAPosition).draw(g2, 980, 120);
		this.holes.get(DataModel.mancalaBPosition).draw(g2, 100, 120);

		int holex = 220;
		int roway = ROWBY + this.holes.get(DataModel.mancalaBPosition).getHeight();

		//set Bs
		for (int i = 1; i < holes.size()/2;i++){
			this.holes.get(i + 7).draw(g2, holex, roway - this.holes.get(i+7).getHeight() + LINEAROFFYSET[i-1]);
			holex += DISTANCEX;
		}

		//set As
		holex = 865;
		for (int i = 1; i < holes.size()/2 ;i++){
			this.holes.get(i).draw(g2, holex, ROWBY - LINEAROFFYSET[i-1]);
			holex -= DISTANCEX;
		}

		//set hole labels
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

	/**
	* returns the height of board
	* @return the height of an integer
	*/
	public int getIconHeight() { return (int)this.HEIGHT; }

	/**
	* returns the width of board
	* @return the width as an integer
	*/
	public 	int getIconWidth() { return (int)this.WIDTH; }
}
