public class DataModel 
{
	Hole holes[] = new Hole[14];
	ArrayList<ChangeListeners> listeners;
	private int nStones;
	
	public DataModel(int nStones)
	{
		this.nStones = nStones;
		this.listeners = new ArrayList<ChangeListeners>();
		fill();
	}
	

	public void move(int position){
		int addPosition;
		int amount_stones = holes[position].getStones();
		holes[position].setStones(0);
		for (int i = 0; i < amount_stones;i++){
			addPosition = position + i;
			if (addPosition >= 14){
				addPosition = 0 + addPosition % 14;
			}
			holes[i].setStones(holes[addPosition].getStones()++);
		}
		if (isMancala(addPosition)){
			move(addPosition);
		} else if (isEmpty(addPosition)){
			int oppStones = holes[14 - addPosition];
			holes[14 - addPosition].setStones(0);
			holes[addPosition].setStones(holes[addPosition].getStones() + oppStones);
		}
		updateBoard();

	}
	private boolean isMancala(int position){
		if (holes[position] instanceof Mancala) {
			return true;
		}
		return false;
	}

	private boolean isEmpty(int position){
		return (holes[position].getStones() == 0);
	}

	public void attachListener(ChangeListeners c){
		listeners.add(c);
	}

	public void updateBoard(){
      	for (ChangeListener l : listeners)
      	{
         	l.stateChanged(new ChangeEvent(this));
      	}
	}

	public void fill()
	{
		for(int i = 2; i < holes.length; i++)
		{
			holes[i] = Pit(nStones);
		}
	}

	public getHoleAmount(int position){
		return holes[position].getStones();
	}
	public int getAmtStart(){
		return nStones;
	}
	
	public Hole[] getData()
	{
		return holes;
	}

}
