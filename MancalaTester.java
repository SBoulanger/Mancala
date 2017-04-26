
import java.util.Scanner;

public class MancalaTester {
	public MancalaTester(){
		
	}
	
	public static void main (String args[]){
                System.out.println("Hi, Welcome to Mancala!");
                Scanner scanner = new Scanner(System.in);
                System.out.println("How many stones would you like to start with? 3 or 4?");
                int amtStart = scanner.nextInt();
                DataModel dm = new DataModel(amtStart);
                Board b = new Board(dm);
                RectangleBoard rectBoard = new RectangleBoard(dm);
                
                JLabel myLabel = new JLabel(rectBoard);
                b.add(myLabel);
                b.setLayout(new FlowLayout());
                b.pack();
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.setVisible(true);

		
	}
}
