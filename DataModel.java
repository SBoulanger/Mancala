import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Samuel Boulanger
 * @author Cindy Ho
 * @author Aldo Barrientos
 * holds/manipulates pits inside holes
 *
 */
public class DataModel 
{
	ArrayList<Hole> holes;
	ArrayList<Hole> pastHoles;
	ArrayList<ChangeListener> listeners;
	private int nStones;
	private boolean justRepeated;
	
	private Pit A1, A2, A3, A4, A5, A6;
	private Mancala A;
	private Pit B1, B2, B3, B4, B5, B6;
	private Mancala B;

	
	private Player player;

	public static int mancalaAPosition = 0;
	public static int mancalaBPosition = 7;
	
	/**
	 * 
	 * helps determined whether game should 
	 * continue or not and who finished
	 *
	 */
	enum GAMECONDITION
	{
		CONTINUE, AFINISHED, BFINISHED ;
	}
	
	/**
	 * obj. which has an array of holes
	 * @param nStones the amount of stones 
	 * each hole will start with
	 */
	public DataModel(int nStones)
	{
		this.nStones = nStones;
		this.holes = new ArrayList<Hole>();
		this.listeners = new ArrayList<ChangeListener>();
		A = new Mancala(0,0);
		this.holes.add(A);
		B1 = new Pit(nStones,1);
		this.holes.add(B1);
		B2 = new Pit(nStones,2);
		this.holes.add(B2);
		B3 = new Pit(nStones,3);
		this.holes.add(B3);
		B4 = new Pit(nStones,4);
		this.holes.add(B4);
		B5 = new Pit(nStones,5);
		this.holes.add(B5);
		B6 = new Pit(nStones,6);
		this.holes.add(B6);
		B  = new Mancala(0,7);
		this.holes.add(B);
		A1 = new Pit(nStones,8);
		this.holes.add(A1);
		A2 = new Pit(nStones,9);
		this.holes.add(A2);
		A3 = new Pit(nStones,10);
		this.holes.add(A3);
		A4 = new Pit(nStones,11);
		this.holes.add(A4);
		A5 = new Pit(nStones,12);
		this.holes.add(A5);
		A6 = new Pit(nStones,13);
		this.holes.add(A6);

		this.pastHoles = new ArrayList<Hole>();
		cloneState();

		player = Player.PLAYERA;

	}
	
    /**
     * controls the algorithms which simulates a move in the 
     * game and manipulates the array 
     * @param position the position where you start your move
     */
	public void move(int position){
		justRepeated = false;
		System.out.println(position);
		GAMECONDITION current; 
		Player winner = null;
		
		 int addPosition = 0; //start position
		 int amount_stones = this.holes.get(position).getStones(); //amount of stones in whatever hole you're in
		 this.holes.get(position).setStones(0); //set the amount of current hole to 0
		 for (int i = 0; i < amount_stones;i++)//do it until you run out of stones
		 {
			 	addPosition = position + i + 1; //to next hole

		 	if (addPosition > 13) //if past mancala a
		 	{
		 		addPosition %= 14; //sets back to 0
		 	}
		 	
		 	if (isMancala(addPosition)) //if current is mancala
		 
			 {  System.out.println("is mancala");

		 		//if you're player a & on mancala 0 then skip or if you're player b & on mancala 7 then skip
			 	 if((player == Player.PLAYERA && addPosition == 7) || (player == Player.PLAYERB && addPosition == 0)) {
			 	 	amount_stones++;
			 	 	continue;

			 	 }
			 }
		 	
			 this.holes.get(addPosition).setStones(this.holes.get(addPosition).getStones()+1); //adding one

		 }
		 
		 
		 if(isMancala(addPosition) && isPlayerHole(player, holes.get(addPosition)))
		 {
			 	justRepeated = true;
		 		togglePlayer();
		 		
		 }
		 else if (wasEmpty(addPosition))
		 {
	 		if(isPlayerHole(player, holes.get(addPosition)))
	 		{	

		 	int oppStones = this.holes.get(14 - addPosition).getStones();
		 	int currStones = this.holes.get(addPosition).getStones();
		 	
		 	this.holes.get(14 - addPosition).setStones(0);
		 	holes.get(addPosition).setStones(currStones + oppStones);
	 		}
		 	
		 }
		 
		 
		 
		 current = gameIsDone();
		 
		 if(current != GAMECONDITION.CONTINUE)
		 {
				System.out.println("game is done");

			if(current == GAMECONDITION.BFINISHED)
			{
				holes.get(0).setStones(getRemainingCount(current) + holes.get(0).getStones());
			}
			
			else
			 {
				 holes.get(7).setStones(getRemainingCount(current) + holes.get(0).getStones());
			 }
			
			for(int i = 0; i < holes.size(); i++)
			{
				if(i == 0 || i == 7)
					continue;
				holes.get(i).setStones(0);
				
			}
			
			winner = whoWon();
			Board.dislayWinner(winner);

			
				
		 }
		 updateBoard();
		 

	}
	
	/**
	 * saves the current states before a move to pastHoles
	 */
	public void saveState(){
		for (int i = 0; i < this.holes.size(); i++){
			this.pastHoles.set(i, this.holes.get(i).clone());
		}
	}
	
	/**
	 * creates the initial copy of holes arraylist
	 */
	public void cloneState(){
		for (Hole h : holes){
			this.pastHoles.add(h.clone());
		}
	}
	
	/**
	 * copies holes to pastHoles before a move
	 */
	public void restorePastData(){
		for (int i = 0; i < this.holes.size(); i++){
			this.holes.set(i, this.pastHoles.get(i));
		}
	}
	
	/**
	 * checks if the current game has ended
	 * @return the game condition which determines
	 * if game is done
	 */
	public GAMECONDITION gameIsDone()
	{
		int aEmptyCount = 0;
		int bEmptyCount = 0;
		
		for(int i = 1; i < 7; i++)
		{
			if(holes.get(i).getStones() == 0)
				bEmptyCount++;
		}
		
		for(int i = 8; i < 13; i++)
		{
			if(holes.get(i).getStones() != 0)
				aEmptyCount++;
		}
		
		
		
		if(aEmptyCount == 6)
			return GAMECONDITION.AFINISHED;
		else if(bEmptyCount == 6)
			return GAMECONDITION.BFINISHED;
		
		return GAMECONDITION.CONTINUE;
		
			
	}
	
	/**
	 * calculates the remaining stones in a player's pits
	 * @param player the player whose stone you want to check
	 * @return amount of stones a player has left
	 */
	public int getRemainingCount(GAMECONDITION player)
	{
		System.out.println("get remaining");
		int j = 0;
		int k = 0;
		int count = 0;
		if(player == GAMECONDITION.AFINISHED)
		{
			 j = 1;
			 k = 7;
		}
		else
		{
			j = 8;
			k =14;
		}
		for(int i = j; j < k; j++)
		{
			count += holes.get(i).getStones();
		}
		return count;
	}
	
	/**
	 * checks if current hole is mancala
	 * @param position the given Hole to be checked
	 * @return true/false if the position is a mancala
	 */
	public boolean isMancala(int position){
		if (this.holes.get(position) instanceof Mancala) {
			return true;
		}
		return false;
	}

	/**
	 * counts up all the stones in each player's mancala
	 * @return which player won or null if there's a tie
	 */
	public Player whoWon()
	{
		if(holes.get(0).getStones() < holes.get(7).getStones())
		{
			System.out.println("player b won");
			return Player.PLAYERB;

		}
		else if(holes.get(0).getStones() > holes.get(7).getStones())
		{
			System.out.println("player a won");
			return Player.PLAYERA;
		}
		
			//if tie
			return null;
			
	}
	
	/**
	 * checks if the hole was empty before you dropped a stone
	 * @param position the current stone to be checked 
	 * @return true/false if the position was empty
	 */
	public boolean wasEmpty(int position){
		return (this.holes.get(position).getStones() == 1);
	}
	
	/**
	 * 
	 * @param position the hole postion
	 * @return if the hole is empty
	 */
	public boolean isEmpty(int position){
		return (this.holes.get(position).getStones() == 0);
	}

	/**
	 * adds a change listener to listeners 
	 * @param c the change listener to attach
	 */
	public void attachListener(ChangeListener c){
		listeners.add(c);
	}

	/**
	 * notifies a state change to all any board
	 */
	public void updateBoard(){
      	for (ChangeListener l : listeners)
      	{
         	l.stateChanged(new ChangeEvent(this));
      	}
	}

	/**
	 * gets the amount of stones in a given Hole
	 * @param position the Hole to be checked
	 * @return the amount of stones in a given Hole
	 */
	public int getHoleAmount(int position){
		return this.holes.get(position).getStones();
	}
	
	/**
	 * gets the amount of starting stones
	 * @return the amount of starting stones
	 */
	public int getAmtStart(){
		return nStones;
	}
	
	/**
	 * gets the arraylist of holes
	 * @return holes the arraylist of holes
	 */
	public ArrayList<Hole> getData()
	{
		return this.holes;
	}
	
	/**
	 * gets the current player
	 * @return the current player
	 */
	public Player getPlayer()
	{
		return player;
	}

	/**
	 * shifts from one player to another after
	 * a turn have been taken
	 */
	public void togglePlayer()
	{
		System.out.println("toggle");
		if(player == Player.PLAYERA)
		{
		
			this.player = Player.PLAYERB;
			
		}
		else
		{
			this.player = Player.PLAYERA;
		}
	}
	
	/**
	 * gets the other player who is not currently playing
	 * @return the other player
	 */
	public Player getOtherPlayer()
	{
		if(player == Player.PLAYERA)
			return Player.PLAYERB;
		
		return Player.PLAYERA;
	}
	
	/**
	 * holds the pastHoles for undo
	 * @return pastHoles the prev board state
	 */
	public ArrayList<Hole> getPastData(){
		return this.pastHoles;
	}
	
	/**
	 * checks if player on a hole that belonds to it
	 * @param p the current player 
	 * @param h the current hole
	 * @return true/false if the whole is the player's
	 */
	public boolean isPlayerHole(Player p, Hole h)
	{
		if(p == Player.PLAYERB)
		{
			if(h.getArrPos() <= 7 && h.getArrPos() > 0)
				return true;

		}
		
		else if(p == Player.PLAYERA)
		{
			if(h.getArrPos() > 7  && h.getArrPos() < 14 || h.getArrPos() == 0)
			return true;
		}
		
		return false;
	}
	
	/**
	 * helps check if a player just went again so that 
	 * undo doesn't toggle 
	 * @return true/false if the player just went again
	 */
	public boolean getJustRepeated()
	{
		return justRepeated;
	}
}
