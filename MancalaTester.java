
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

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
                System.out.println("Which layout would you like? (1) Rectangular (2) Circular");
                int choice = scanner.nextInt();
                if(choice == 1){
                        b.attachBoardLayout(new RectangleBoard(dm.getData()));
                }
                if(choice == 2){
                        b.attachBoardLayout(new CircularBoard(dm.getData()));
                }
                dm.attachListener(b);
                //JLabel myLabel = new JLabel();
                //b.add(myLabel);
                //b.setLayout(new FlowLayout());
                b.pack();
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.setVisible(true);

		
	}
}
