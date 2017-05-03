import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class MancalaTester {

        enum BoardChoice {
                RECTANGLE, CIRCLE
        }
        private static BoardChoice choice;
        private static int pebbleCount;
	public MancalaTester(){
		
	}
	
	public static void main (String args[]){

                doInitProcess1();
		
	}

        public static void doInitProcess1(){
                JFrame initframe = new JFrame();
                initframe.setLayout(new FlowLayout());
                JLabel initLabel = new JLabel("Which Board do you choose?");
                initframe.add(initLabel);
                JButton rectButton = new JButton("Rectangle");
                rectButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                initframe.dispose();
                                choice = BoardChoice.RECTANGLE;
                                doInitProcess2();
                        }
                });
                JButton circleButton = new JButton("Circle");
                circleButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                initframe.dispose();
                                choice = BoardChoice.CIRCLE;
                                doInitProcess2();
                        }
                });
                initframe.add(rectButton);
                initframe.add(circleButton);


                initframe.pack();
                initframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                initframe.setVisible(true);

        }
        public static void doInitProcess2(){
                JFrame initframe = new JFrame();
                initframe.setLayout(new FlowLayout());
                JLabel initLabel = new JLabel("How many pebbles?");
                initframe.add(initLabel);
                JButton rectButton = new JButton("3");
                rectButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                initframe.dispose();
                                pebbleCount = 3;
                                doInitProcess3();
                        }
                });
                JButton circleButton = new JButton("4");
                circleButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                initframe.dispose();
                                pebbleCount = 4;
                                doInitProcess3();
                        }
                });
                initframe.add(rectButton);
                initframe.add(circleButton);


                initframe.pack();
                initframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                initframe.setVisible(true);

        }
        public static void doInitProcess3(){
                //System.out.println("Hi, Welcome to Mancala!");
                //Scanner scanner = new Scanner(System.in);
                //System.out.println("How many stones would you like to start with? 3 or 4?");
                //int amtStart = scanner.nextInt();

                DataModel dm = new DataModel(pebbleCount);
                Board b = new Board(dm);
                //System.out.println("Which layout would you like? (1) Rectangular (2) Circular");
                //int choice = scanner.nextInt();
                if(choice == BoardChoice.RECTANGLE){
                        b.attachBoardLayout(new RectangleBoard(dm.getData()));
                }
                if(choice == BoardChoice.CIRCLE){
                        b.attachBoardLayout(new CircularBoard(dm.getData()));
                }
                dm.attachListener(b);
                b.pack();
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.setVisible(true);


        }
}
