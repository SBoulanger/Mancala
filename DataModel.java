
public class DataModel 
{
	//
	int holes[] = new int[14];
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
			holes[i] = startPebbles;
		}		
	}
	
	public int[] getData()
	{
		return holes;
	}

	public void move()
}
