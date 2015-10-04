
import java.io.*;
import java.util.Scanner;
public class Mancala{
    public static void main (String args[]) throws IOException {
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader stdin = new BufferedReader (reader);
        
        //Plyer 1 move input
        int oneMove;
        //Player 2 move input
        int twoMove;
        
        //Create Board
        Board board = new Board();
        
        //Initialize
        board.initcell();
        
        //Player Object1
        System.out.println("Hello Player one! Enter your name!");
        String oneName = stdin.readLine();
        Player playerOne = new Player(1,oneName);
        
        //Player Object2
        System.out.println("Hello Player two! Enter your name!");
        String twoName = stdin.readLine();
        Player playerTwo = new Player(2,twoName);
        
        System.out.println("WELCOME TO MANCALA!");
        
        Scanner in = new Scanner(System.in);
        String choice = "";
        int playerMove = -1;
        
        do{
            //Draw Board
            board.drawcell();
            
            //Check Player 1 valid input
            System.out.println("Hey " + playerOne.getName() + ", which dip do you want to move?");
            do{
                choice = in.nextLine();
            }while(!validInput(choice, playerOne));
             
            //Parses choice into integer and calls move function
            playerMove = Integer.parseInt(choice);
            board.move(playerMove, playerOne);
            
            board.drawcell();
            
            if(!board.checkWin()){
 
                //Check Player 2 valid input
                System.out.println("So " + playerTwo.getName() + ", which dip do you want to move?");
                do{
                    choice = in.nextLine();
                }while(!validInput(choice, playerTwo));
            
                //Player two move function call
                playerMove = Integer.parseInt(choice);
                board.move(playerMove, playerTwo);
            }
          }while(!board.checkWin());
        
        //After determining who the winner is we print out the player name
        if(board.getScore(playerOne.getID()) > board.getScore(playerTwo.getID())){
            System.out.println("Congratulations " + playerOne.getName() + "! You win!");
        }
            
        if(board.getScore(playerTwo.getID()) > board.getScore(playerOne.getID())){
            System.out.println("Congratulations " + playerTwo.getName() + "! You win!");
        }
            
        if(board.getScore(playerTwo.getID()) == board.getScore(playerOne.getID())){
            System.out.println("You both tied! What a bunch of losers.");
        }
            
    }
    
    private static boolean validInput(String input, Player player){
      int id = player.getID();
      int choice;
	  boolean ret = false;
      
      try{
      
         choice = Integer.parseInt(input);  
      }
      catch(NumberFormatException e){
      
         System.out.println("\nInvalid input\n");
         return false; 
      }
      
      switch(id){
         case 1:
            if(choice >= 0 && choice <= 5)
               ret = true;
            break;
         case 2:
            if(choice >= 7 && choice <= 12)
               ret = true;
            break;
         default:
            System.out.print("\nInvalid Dip");
            ret = false;
      }
	  return ret;
   }
    
}