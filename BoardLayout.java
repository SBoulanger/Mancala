
import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.JLabel;
import java.awt.geom.GeneralPath;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public abstract class BoardLayout extends JLabel {

	//public GeneralPath pathA;
	//public GeneralPath pathB;

	public BoardLayout(){
		this.setPreferredSize(new Dimension(getWidth(), getHeight()));
	}

	public void paintComponent(Graphics g){
		draw(g);
	}

	abstract public void draw(Graphics g);
	abstract public int getHeight();
	abstract public int getWidth();

}