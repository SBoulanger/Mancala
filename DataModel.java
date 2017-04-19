package mancala;

public class DataModel 
{
	int holes[] = new int[14];
	int startPebbles;
	
	public DataModel(int startPebbles)
	{
		this.startPebbles = startPebbles;
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
}
