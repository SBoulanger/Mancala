import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

/**
 * @author Samuel Boulanger
 * @author Cindy Ho
 * @author Aldo Barrientos
 * acts a controller which manipulates views and sends input to model
 *
 */
public class Board extends JFrame implements ChangeListener 
{
	public DataModel model;
	public BoardLayout layout;
	public ArrayList<Hole> holes;

	private JLabel turnLabel;
	private JButton undoButton;

	private final int HEIGHT = 620;
	private final int WIDTH = 1220;

	/**
	* constructor that creates board
	* @param dm datamodel that handles data
	*/
	public Board(DataModel dm){
		this.model = dm;
		int n = model.getAmtStart();
		this.holes = model.getData();

		setLayout(new BorderLayout());

		/**
		 * detects input and sends input to model
		 */
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
		
		addMouseListener(ml);
		
	}
	
	/**
	 * uses a BoardLayout to set the view 
	 * @param bl the BoardLayout used to set view
	 */
	public void attachBoardLayout(BoardLayout bl){
		this.layout = bl;
		JLabel jl = new JLabel(bl);
		jl.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(jl,BorderLayout.CENTER);
		JPanel panel = new JPanel();
		turnLabel = new JLabel("Undos left: "+(3-model.getPlayer().getUndos())+" "+model.getPlayer().toString());
		undoButton = new JButton("undo");
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("undo");

				if (model.getPlayer().canUndo()){
					model.restorePastData();
					if(model.getJustRepeated() == false)
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
	
	/**
	 * when a change has been detected in data model, method is called ot repaint new data
	 * @param e event for change event
	 */
	public void stateChanged(ChangeEvent e){
		repaint();
	}

	/**
	 * displays the winner once game ends 
	 * @param p the player who will be displayed as winner
	 */
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
}
