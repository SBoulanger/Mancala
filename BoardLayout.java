

import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.JLabel;
import java.awt.geom.GeneralPath;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public abstract class BoardLayout implements Icon {

	public ArrayList<Hole> holes;

	public BoardLayout(){
		
	}

	abstract public void paintIcon(Component c,Graphics g, int x, int y);
	abstract public int getIconHeight();
	abstract public int getIconWidth();

}