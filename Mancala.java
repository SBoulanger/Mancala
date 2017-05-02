
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
 
 class Mancala extends Hole 
 {
	
	private int pebbleX;
	private int pebbleY;

	public Mancala(int pebbles, int id) 
	{
		
		super(pebbles, id);
		
	}
	
	    public void draw(Graphics2D g2, int x, int y){
		Ellipse2D hole = new Ellipse2D.Double(x, y, 120, 360);
        this.drawStones(g2, x, y);
        g2.draw(hole);
	}
	    
	    public void drawStones(Graphics2D g2, int x, int y)
		{
			for(int i = 0; i < this.getStones(); i++)
			{
				translatePebble(x, y, i);
				Stone pebble = new Stone();
				pebble.draw(g2, pebbleX, pebbleY);
			}
		}
		
		public void translatePebble(int x, int y, int z)
		{
			pebbleX = (int) (Math.cos(z * 3.14f / 2 - 3.14f / 2) * 30 + (x + 50)); 
			pebbleY = (int) (Math.sin(z * 3.14f / 2 - 3.14f / 2) * 30 + (y + 180));	
		}
 }
