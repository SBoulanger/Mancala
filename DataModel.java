import java.util.ArrayList;

import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;

public class DataModel 
{
	ArrayList<Hole> holes;
	ArrayList<Hole> pastHoles;
	ArrayList<ChangeListener> listeners;
	private int nStones;
	
	private Pit A1;
	private Pit A2;
	private Pit A3;
	private Pit A4;
	private Pit A5;
	private Pit A6;
	private Mancala B;
	private Pit B1;
	private Pit B2;
	private Pit B3;
	private Pit B4;
	private Pit B5;
	private Pit B6;
	private Mancala A;
	
	
	enum GAMECONDITION
	{
		CONTINUE, AFINISHED, BFINISHED ;
	}
	
	
	public DataModel(int nStones)
	{
		this.nStones = nStones;
		this.holes = new ArrayList<Hole>();
		this.listeners = new ArrayList<ChangeListener>();
		B  = new Mancala(0,0);
		this.holes.add(B);
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
		A = new Mancala(0,7);
		this.holes.add(A);
		A6 = new Pit(nStones,8);
		this.holes.add(A6);
		A5 = new Pit(nStones,9);
		this.holes.add(A5);
		A4 = new Pit(nStones,10);
		this.holes.add(A4);
		A3 = new Pit(nStones,11);
		this.holes.add(A3);
		A2 = new Pit(nStones,12);
		this.holes.add(A2);
		A1 = new Pit(nStones,13);
		this.holes.add(A1);

		this.pastHoles = new ArrayList<Hole>();
		saveState();
	}
	

	public void move(int position){
		 int addPosition = 0;
		 saveState();
		 int amount_stones = this.holes.get(position).getStones();
		 this.holes.get(position).setStones(0);
		 for (int i = 0; i < amount_stones;i++){
		 	addPosition = position + i + 1;
		 	if (addPosition >= 14){
		 		addPosition = 0 + addPosition % 14;
		 	}
		 	this.holes.get(addPosition).setStones(this.holes.get(addPosition).getStones()+1);
		 }
		 if (isMancala(addPosition)){
		 	move(addPosition);
		 } else if (isEmpty(addPosition)){
		 	int oppStones = this.holes.get(14 - addPosition).getStones();
		 	this.holes.get(14 - addPosition).setStones(0);
		 	this.holes.get(addPosition).setStones(this.holes.get(addPosition).getStones() + oppStones);
		 }
		 
		 GAMECONDITION current = gameIsDone();
		 
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
			
			Player winner = whoWon();
		 }
		 
		 updateBoard();

	}
	public void saveState(){
		for (int i = 0; i < this.holes.size(); i++){
			this.pastHoles.set(i, this.holes.get(i).clone());
		}
	}
	
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
	
	public int getRemainingCount(GAMECONDITION player)
	{
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
	public boolean isMancala(int position){
		if (this.holes.get(position) instanceof Mancala) {
			return true;
		}
		return false;
	}

	public Player whoWon()
	{
		if(holes.get(0).getStones() > holes.get(7).getStones())
			return Player.PLAYERB;
		else if(holes.get(0).getStones() < holes.get(7).getStones())
			return Player.PLAYERA;
		else
			return null;
			
	}
	public boolean isEmpty(int position){
		return (this.holes.get(position).getStones() == 0);
	}

	public void attachListener(ChangeListener c){
		listeners.add(c);
	}

	public void updateBoard(){
      	for (ChangeListener l : listeners)
      	{
         	l.stateChanged(new ChangeEvent(this));
      	}
	}

	public int getHoleAmount(int position){
		return this.holes.get(position).getStones();
	}
	public int getAmtStart(){
		return nStones;
	}
	
	public ArrayList<Hole> getData()
	{
		return this.holes;
	}

}
