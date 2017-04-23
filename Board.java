package mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JPanel;

public class Board implements Icon implements ChangeListener extends JFrame 
{
	DataModel model;
	private Hole[] holes;
	private boolean isPlayerA; //true = A, false = B
	private RectangleBoard rectBoard;	
		int n = model.getAmtStart;
		this.model = model;
		
		MouseListener ml = new MouseListener(){
			public void mouseClicked(MouseEvent e) 
			{
				int x;
				int y;
				x = e.getX();
				y = e.getY();
				if(A1.contains(x,y)){
					model.move(A1.getArrPos());
				}
				else if(A2.contains(x,y)){
					model.move(A2.getArrPos());
				}
				else if(A3.contains(x,y)){
					model.move(A3.getArrPos());
				}
				else if(A4.contains(x,y)){
					model.move(A4.getArrPos());
				}
				else if(A5.contains(x,y)){
					model.move(A5.getArrPos());
				}
				else if(A6.contains(x,y)){
					model.move(A6.getArrPos());
				}
				else if(B1.contains(x,y)){
					model.move(B1.getArrPos());
				}
				else if(B2.contains(x,y)){
					model.move(B2.getArrPos());
				}
				else if(B3.contains(x,y)){
					model.move(B3.getArrPos());
				}
				else if(B4.contains(x,y)){
					model.move(B4.getArrPos());
				}
				else if(B5.contains(x,y)){
					model.move(B5.getArrPos());
				}
				else if(B6.contains(x,y)){
					model.move(B5.getArrPos());
				}
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		}
		
		JPanel jp = new JPanel();
		jp.addMouseListener(ml);
		
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < 14; i++)
        {
        	holes[i].drawStones(g2);
        }
        
	}

	public int getIconWidth() 
	{
		return 0;
	}
	
	public Board(DataModel model, BoardType board)
	{
		this.model = model;
		
		rectBoard = new RectangleBoard(model);	
	}
	 
	
	public void addChangeListener(ChangeListener listener){
		model.attachListener(listener);
		stateChanged();
	}
	
	public void stateChanged(ChangeEvent e){
		repaint();
	}
}
