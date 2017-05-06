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
	public static void dislayWinner(Player p)
	{
		JFrame wf = new JFrame();
		 
		String winner = "PLAYER A!";
		if(p == Player.PLAYERB)
			winner = "PLAYER B!";
		
		Font labelFont = new Font("Arial", Font.PLAIN, 100);

		System.out.println("THE WINNER IS " + winner);
		
		JLabel label = new JLabel("THE WINNER IS " + winner);

		label.setFont(labelFont);

		wf.add(label);
		
		wf.pack();
        wf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wf.setVisible(true);		
	}

	abstract public void paintIcon(Component c,Graphics g, int x, int y);
	abstract public int getIconHeight();
	abstract public int getIconWidth();

}