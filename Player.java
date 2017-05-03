
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
	
	public boolean checkFirstTurn()
	{
		if(turn == TURNCHECK.JUSTWENT)
			return false;
		return true;
					
	}
	
	public void setJustWent()
	{
		turn = TURNCHECK.JUSTWENT;
	}
	
	public void setFirstTurn()
	{
		turn = TURNCHECK.FIRSTTURN;
	}
}
