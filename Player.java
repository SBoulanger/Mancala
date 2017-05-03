
public enum Player 
{
	PLAYERA(0), PLAYERB(0);
	private int undos;
	private Player(int n){
		undos = n;
	}
	public String toString(){ if (this == PLAYERA) {return "Player A";} else {return "Player B";}}
	public void undid(){
		this.undos++;
	}
	public boolean canUndo(){
		if this.undos < 3 {
			return true;
		}
		return false;
	}
}