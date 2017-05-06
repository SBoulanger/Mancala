import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.JLabel;
import java.awt.geom.GeneralPath;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;


/**
* interface to describe different Mancala board layouts and extends Icon
*/
interface BoardLayout extends Icon {
	/**
	* Algorithm for drawing the board layout
	* @param graphics object to render board on 
	*/
	public void drawBoard(Graphics2D g2);
}