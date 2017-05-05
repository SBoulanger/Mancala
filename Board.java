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
					for (int i = 8; i < holes.size(); i++){
						
						h = holes.get(i);
						if (!model.isMancala(h.getArrPos()) && h.contains(x, y) && !model.isEmpty(h.getArrPos())){
							model.saveState();
							model.move(h.getArrPos());
							model.getPlayer().setJustWent();;
							model.getOtherPlayer().setFirstTurn();	
							model.togglePlayer();
							turnLabel.setText("Undos left: "+(3-model.getPlayer().getUndos())+" "+model.getPlayer().toString());
						}
					}
				} else {
					for (int i = 1; i < holes.size()/2; i++){
						h = holes.get(i);
						if (!model.isMancala(h.getArrPos()) && h.contains(x, y) && !model.isEmpty(h.getArrPos())){
							model.saveState();
							model.move(h.getArrPos());
							model.getPlayer().setJustWent();
							model.getOtherPlayer().setFirstTurn();
							model.togglePlayer();
							turnLabel.setText("Undos left: "+(3-model.getPlayer().getUndos())+" "+model.getPlayer().toString());
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
		turnLabel = new JLabel("Undos left: "+(3-model.getPlayer().getUndos())+" "+model.getPlayer().toString());
		undoButton = new JButton("undo");
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("undo");

				if (model.getPlayer().canUndo()){
					model.restorePastData();
					model.togglePlayer();
					model.getPlayer().undid();
					turnLabel.setText("Undos left: "+(3-model.getPlayer().getUndos())+" "+model.getPlayer().toString());
					repaint();
				}
			}
		});
		panel.add(turnLabel);
		panel.add(undoButton);
		add(panel,BorderLayout.SOUTH);
	}
	public void stateChanged(ChangeEvent e){
		repaint();
	}
}
