import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
* @author Samuel Boulanger
* @author Cindy Ho
* @author Aldo Barrientos
* interface to describe different Mancala board layouts and extends Icon
*/
interface BoardLayout extends Icon {
	/**
	* Algorithm for drawing the board layout
	* @param g2 graphics object to render board on 
	*/
	public void drawBoard(Graphics2D g2);
}