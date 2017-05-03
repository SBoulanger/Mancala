
public enum Player 
{
	
	PLAYERA(0), PLAYERB(0);
	
	enum TURNCHECK
	{
		JUSTWENT, FIRSTTURN,
	};
	
	private int undos;
	private Player p;
	private TURNCHECK turn;
	private Player(int n){
		
		undos = n;
	}
	public String toString(){ if (this == PLAYERA) {return "Player A";} else {return "Player B";}}
	public void undid(){
		this.undos++;
	}
	public boolean canUndo(){
		if (this.undos < 3 && checkFirstTurn()) {
			
			return true;
		}
			
		return false;
	}
<<<<<<< HEAD
	
	public boolean checkFirstTurn()
	{
		if(turn == TURNCHECK.JUSTWENT)
			return false;
		return true;
					
	}
	
	public void setJustWent()
	{
		turn = TURNCHECK.JUSTWENT;
		System.out.println(this.toString() + "set just went");
	}
	
	public void setFirstTurn()
	{
		turn = TURNCHECK.FIRSTTURN;
		System.out.println(this.toString() + "set first turn");

	}
	
	public void getTurnThing()
	{
		if(turn == TURNCHECK.JUSTWENT)
			System.out.println(this.toString() + "Just went");
		else
			System.out.println(this.toString() + "First turn");

	}
	
=======
>>>>>>> 958d8bab64ed352e52d8e904333d2c7dbadc7883
}
