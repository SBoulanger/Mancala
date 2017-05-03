
public enum Player 
{
	PLAYERA(0), PLAYERB(0);
	private int undos;
	private boolean hasmoved;
	private Player(int n){
		undos = n;
		hasmoved = false;
	}
	public String toString(){ if (this == PLAYERA) {return "Player A";} else {return "Player B";}}
	public void undid(){
		hasmoved = false;
		this.undos++;
	}
	public boolean canUndo(){
		if (this.undos < 3 && getOtherPlayer().hasmoved) {
			return true;
		}
		return false;
	}
	public void toggleHasMoved(){
		hasmoved = !hasmoved;
	}
	public Player getOtherPlayer(){
		if (this == Player.PLAYERA){
			return Player.PLAYERB;
		} else {
			return Player.PLAYERA;
		}
	}
	public void setMovedFalse(){
		hasmoved = false;
	}
}
