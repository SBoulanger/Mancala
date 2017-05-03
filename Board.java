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
	public DataModel model;
	public BoardLayout layout;
	public ArrayList<Hole> holes;
	private RectangleBoard rectBoard;

	private JLabel turnLabel;
	private JButton undoButton;

	private int height = 620;
	private int width = 1220;

	public Board(DataModel dm){
		this.model = dm;
		int n = model.getAmtStart();
		this.holes = model.getData();

		setLayout(new BorderLayout());

		MouseListener ml = new MouseListener(){
			public void mouseClicked(MouseEvent e) 
			{
				int x;
				int y;
				x = e.getX();
				y = e.getY();
				Hole h;
				if (model.getPlayer() == Player.PLAYERA){
					for (int i = 7; i < holes.size(); i++){
						h = holes.get(i);
						if (!model.isMancala(h.getArrPos()) && h.contains(x, y) && !model.isEmpty(h.getArrPos())){
							model.move(h.getArrPos());
							model.togglePlayer();
							turnLabel.setText(model.getPlayer().toString());
						}
					}
				} else {
					for (int i = 0; i < holes.size()/2; i++){
						h = holes.get(i);
						if (!model.isMancala(h.getArrPos()) && h.contains(x, y) && !model.isEmpty(h.getArrPos())){
							model.move(h.getArrPos());
							model.togglePlayer();
							turnLabel.setText(model.getPlayer().toString());
						}
					}
				}
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		
		JPanel jp = new JPanel();
		addMouseListener(ml);
		
	}
	public void attachBoardLayout(BoardLayout bl){
		this.layout = bl;
		JLabel jl = new JLabel(bl);
		jl.setPreferredSize(new Dimension(width, height));
		add(jl,BorderLayout.CENTER);
		JPanel panel = new JPanel();
		turnLabel = new JLabel(model.getPlayer().toString());
		undoButton = new JButton("undo");
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				holes = pastHoles;
				model.togglePlayer();
				turnLabel.setText(model.getPlayer().toString());
				repaint();
			}
		})
		panel.add(turnLabel);
		panel.add(undoButton);
		add(panel,BorderLayout.SOUTH);
	}
	public void stateChanged(ChangeEvent e){
		repaint();
	}
}
