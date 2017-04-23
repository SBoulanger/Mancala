<<<<<<< HEAD
package mancala;

=======
>>>>>>> master
public class DataModel 
{
	Hole holes[] = new Hole[14];
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
			holes[i] = new Pit(startPebbles);
		}
	}
	
	public Hole[] getData()
	{
		return holes;
	}
}
