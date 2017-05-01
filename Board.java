
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame implements ChangeListener 
{
	DataModel model;
	public BoardLayout layout;
	public ArrayList<Hole> holes;
	private boolean isPlayerA; //true = A, false = B
	private RectangleBoard rectBoard;


	public Board(DataModel dm){
		this.model = dm;
		int n = model.getAmtStart();
		this.holes = model.getData();


		MouseListener ml = new MouseListener(){
			public void mouseClicked(MouseEvent e) 
			{
				int x;
				int y;
				x = e.getX();
				y = e.getY();
				
				for (Hole h : holes){
					if (!(h instanceof Mancala) && h.contains(x, y)){
						model.move(h.getArrPos());
					}
				}
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		
		JPanel jp = new JPanel();
		jp.addMouseListener(ml);
		add(jp);
		
	}
	public void attachBoardLayout(BoardLayout bl){
		this.layout = bl;
		JLabel jl = new JLabel(bl);
		jl.setPreferredSize(new Dimension(bl.getIconWidth(), bl.getIconHeight()));
		add(jl);
	}
	//public void paintComponent(Graphics g){
	//	layout.draw(g);
	//}
	
	/*public void addChangeListener(ChangeListener listener){
		model.attachListener(listener);
	}*/
	
	public void stateChanged(ChangeEvent e){
		repaint();
	}
}
