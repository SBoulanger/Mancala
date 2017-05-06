/**
 * 
 * enum helps determine current player and tracks undos
 *
 */
public enum Player 
{
	
	PLAYERA(0), PLAYERB(0);
	/**
	 * 
	 * helps track player undos in same turns
	 *
	 */
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
	
	/**
	 * adds to the total undid count
	 */
	public void undid(){
		this.undos++;
	}
	
	/**
	 * determines whether the current player can undo
	 * @return true if player can undo, false if can't
	 */
	public boolean canUndo(){
		if (this.getOtherPlayer().undos < 3 && checkFirstTurn()) {
			return true;
		}
			
		return false;
	}
	
	/**
	 * gets instance of other player 
	 * @return the other player
	 */
	public Player getOtherPlayer(){
		if (this == PLAYERA){
			return PLAYERB;
		}
		return PLAYERA;	
	}
	
	/**
	 * checks if this is the first move in same turn
	 * @return true if first, false if second
	 */
	public boolean checkFirstTurn()
	{
		if(turn == TURNCHECK.JUSTWENT)
			return false;
		return true;
					
	}
	
	/**
	 * sets turn to just went if player already 
	 * moved in same turns
	 */
	public void setJustWent()
	{
		turn = TURNCHECK.JUSTWENT;
	}
	
	/**
	 * sets first turn if other player has moved
	 */
	public void setFirstTurn()
	{
		turn = TURNCHECK.FIRSTTURN;
	}
	
	/**
	 * gets the total undo count
	 * @return undos the total undo count
	 */
	public int getUndos(){
		return undos;
	}
}
