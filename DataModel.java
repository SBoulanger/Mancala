
public class DataModel 
{
	Hole holes[] = new Hole[14];
	int nStones;
	
	public DataModel(int nStones)
	{
		this.nStones = nStones;
		fill();
	}
	
	public void fill()
	{
		for(int i = 2; i < holes.length; i++)
		{
			holes[i] = Pit(nStones);
		}		
	}
	
	public Hole[] getData()
	{
		return holes;
	}

	public void move()
}
