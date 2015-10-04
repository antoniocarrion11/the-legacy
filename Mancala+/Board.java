import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board
{
    private ArrayList<ArrayList<Bead>> cell;
	private static final int boardsize = 14;	//used for possible debugging, the size of the cell including score dips
	private static final int maxbeads = 48;	//used for debugging/possible game modification
	private static final int beadsperdip = maxbeads/(boardsize-2);	//determines the beads per dip
	
	//default constructor, makes the cell with dips
	public Board()
	{
		//Random rand = new Random();
		cell = new ArrayList<ArrayList<Bead>>();
		for(int i=0;i<Board.boardsize;i++)
		{
			cell.add(i,new ArrayList<Bead>());
		}
	}
	
	//temp accessor method
	public ArrayList<ArrayList<Bead>> getcell()
	{
		return cell;
	}
	
	//used to initialize the game board with beads into each dip
	public void initcell()
	{
		
		Random rand = new Random();
		int r=0,o=0,b=0;
		
		//find dip for orange bead to go initially
		o = rand.nextInt(Board.boardsize);
		while(o == 6 || o == 13)
		{
			o = rand.nextInt(Board.boardsize);
		}
		
		//find dip for red bead to go initially
		r = rand.nextInt(Board.boardsize);
		while(r == o || r == 6 || r == 13)
		{
			r = rand.nextInt(Board.boardsize);
		}
		
		//find dip for blue bead to go initially
		b = rand.nextInt(Board.boardsize);
		while(b == r || b == o || b == 6 || b == 13)
		{
			b = rand.nextInt(Board.boardsize);
		}
		
		//these above currently do not let more than one special bead start in a dip
		//this can be changed
		
		//place special beads into their proper dip
		cell.get(o).add(new OrangeBead());
		cell.get(b).add(new BlueBead());
		cell.get(r).add(new RedBead());
		
		//place the "rest" of the beads, this is calculated using static values above
		for(int i=0;i<Board.boardsize;i++)
		{
			if(i != 6 && i != 13)
			{
				while(cell.get(i).size() < Board.beadsperdip)
				{
					cell.get(i).add(new Bead());
				}
			}
			
		}
		
	}
	
	//count the number of orange beads in the dip at index
	//helper method
	private int countO(int index)
	{
		int count=0;
		for(int j=0;j<cell.get(index).size();j++)
		{
			if(cell.get(index).get(j) instanceof OrangeBead)
			{
				count++;
			}
		}
		return count;
	}
	
	//count the number of red beads in the dip at index
	//helper method
	private int countR(int index)
	{
		int count=0;
		for(int j=0;j<cell.get(index).size();j++)
		{
			if(cell.get(index).get(j) instanceof RedBead)
			{
				count++;
			}
		}
		return count;
	}
	
	//count the number of blue beads in the dip at index
	//helper method
	private int countB(int index)
	{
		int count=0;
		for(int j=0;j<cell.get(index).size();j++)
		{
			if(cell.get(index).get(j) instanceof BlueBead)
			{
				count++;
			}
		}
		return count;
	}
	
	//count the number of white beads in the dip at index
	//note, the beads here CANNOT be instance of anything other than bead
	//helper method
	private int countW(int index)
	{
		int count=0;
		for(int j=0;j<cell.get(index).size();j++)
		{
			if( !(cell.get(index).get(j) instanceof OrangeBead) && !(cell.get(index).get(j) instanceof RedBead) && !(cell.get(index).get(j) instanceof BlueBead) && (cell.get(index).get(j) instanceof Bead) )
			{
				count++;
			}
		}
		return count;
	}
	
	//count the number of beads in the dip at index
	//note, this includes ALL beads
	//helper method
	private int countA(int index)
	{
		int count=0;
		for(int j=0;j<cell.get(index).size();j++)
		{
			if(cell.get(index).get(j) instanceof Bead)
			{
				count++;
			}
		}
		return count;
	}
	
	//get score method, takes int as parameter to designate player
	public int getScore(int player)
	{
		//if player numbers are 0 or 1, use top line
		//if player numbers are 1 or 2, use bottom line
		
		//return countA(7*player);
		return countA(7*(player-1)+6);
	}
	
	//check win method, to see if the game is over
	public boolean checkWin()
	{
		//for ease of coding, default is true
		boolean over=true;
		for(int i=0;i<Board.boardsize;i++)
		{
			if( (i != 6) && (i != 13) )
			{
				if( countA(i) != 0) { over = false; }
			}
		}
		return over;
	}
	
   public void move(int dip, Player player) 
   {      
      int whiteBeads  = countW(dip);
      int orangeBeads = countO(dip);
      int redBeads    = countR(dip);
      int blueBeads   = countB(dip);
      int index       = dip+1;
      
      for(int beadsMoved = 0; beadsMoved < whiteBeads; beadsMoved++)
      {
         if(index > 13)
            index = 0;
         
         cell.get(index).add(new Bead());
         
         index++;
      }
	  
	  if(index == 14) { index = 0; }
      
      int colorCount = orangeBeads + redBeads + blueBeads;
      switch(colorCount){
         case 0:
            break;
         case 1:   
            if(orangeBeads > 0)
               orangeMove(index, player);
               
            if(redBeads > 0)
               redMove(index, player);
               
            if(blueBeads > 0)
               blueMove(index, player);
            break;
         case 2:
            if(blueBeads == 1 && redBeads == 1)
            {
               cell.get(index).add(new BlueBead());
               index++;
               redMove(index, player);
            }
            if(blueBeads == 1 && orangeBeads == 1)
            {
               cell.get(index).add(new BlueBead());
               index++;
               orangeMove(index, player);
            } 
            if(redBeads == 1 && orangeBeads == 1)
            {
               cell.get(index).add(new RedBead());
               index++;
               orangeMove(index, player);
            }     
            break;
         case 3:
            cell.get(index).add(new BlueBead());
            index++;
            cell.get(index).add(new RedBead());
            index++;
            orangeMove(index, player);
            break;      
      }      
         
      cell.get(dip).clear();            
      
   }
   
   public void orangeMove(int index, Player player)
   {
      
      int id = player.getID();
      
      switch(id){
         case 1:
            if(index == 6){
               orangeSpecial(index, player);
            }
            else
               cell.get(index).add(new OrangeBead());
            break;
         case 2:
            if(index == 13){
               orangeSpecial(index, player);
            }
            else
               cell.get(index).add(new OrangeBead());
            break;
      }
   }
   
   public void redMove(int index, Player player)
   {
      int id = player.getID();
      
      switch(id){
         case 1:
            if(index == 6 || index == 13){
               redSpecial(index, player);
            }
            else
               cell.get(index).add(new RedBead());
            break;
         case 2:
            if(index == 6 || index == 13){
               redSpecial(index, player);
            }
            else
               cell.get(index).add(new RedBead());
            break;
      }
   }
   
   public void blueMove(int index, Player player)
   {
      cell.get(index).add(new Bead());
      if( index != 13 && index != 6){
        move(index, player);
      }
      
   }
   
   public void orangeSpecial(int index, Player player)
   {
      Scanner in = new Scanner(System.in);
      int id = player.getID();
      String input = "";
      int choice;
      
      System.out.println("Choose a cell to destroy " + player.getName() +"!!!");
      
      switch(id){
         case 1:
            do{
               input = in.nextLine();
            }while(!validInput(input, player));
            break;
         case 2:
            do{
               input = in.nextLine();
            }while(!validInput(input, player));
            break;
         default:
            System.out.print("\nInvalid Dip");
            break;
      }
      
      choice = Integer.parseInt(input);
      cell.get(choice).clear();      
      
   }
   
   private void redSpecial(int index, Player player)
	{
        cell.get(index).add(new Bead());
		int count = countA(index)/2;
		cell.get(index).clear();
		for(int i=0;i<count;i++)
			cell.get(index).add(new Bead());
		
      int tindex = 0;
      
		switch(player.getID())
		{
			case 1:
				for(int i=0;i<count;i++)
				{
					if(tindex > 5) { tindex = 0; }
					cell.get(0+tindex).add(new Bead());
					tindex++;
				}
				break;
			case 2:
				for(int i=0;i<count;i++)
				{
					if(tindex > 5) { tindex = 0; }
					cell.get(7+tindex).add(new Bead());
					tindex++;
				}
		}
		
		
	}
   
   private boolean validInput(String input, Player player)
   {
      int id = player.getID();
      int choice;
	  boolean ret=false;
      try
      {
         choice = Integer.parseInt(input);
      } catch(NumberFormatException e)
      {
         System.out.println("\nInvalid input\n");
         return false; 
      }
      
      switch(id){
         case 1:
            if(choice >= 7 && choice <= 12)
               ret = true;
            break;
         case 2:
            if(choice >= 0 && choice <= 5)
               ret = true;
            break;
         default:
            System.out.print("\nInvalid Dip");
            ret = false;
      }
	  return ret;
   }
     
	//method to draw the game board, complete with bead counts and scores
	public void drawcell()
	{
		System.out.format("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
		System.out.format("+---------------------------------------------------------------------------+%n");
		System.out.format("| PLAYER 2   12        11        10        9         8         7            |%n");
		System.out.format("| +----+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +----+ |%n");
		System.out.format("| | %02d | |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |T  S| |%n", this.getScore(2),  this.countB(12),this.countO(12),  this.countB(11),this.countO(11),  this.countB(10),this.countO(10),  this.countB(3),this.countO(9),  this.countB(8),this.countO(8),  this.countB(7),this.countO(7));
		System.out.format("| |    | |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |O  C| |%n",                      this.countR(12),this.countW(12),  this.countR(11),this.countW(11),  this.countR(10),this.countW(10),  this.countR(3),this.countW(9),  this.countR(8),this.countW(8),  this.countR(7),this.countW(7));
		System.out.format("| |T  S| +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ |T  O| |%n");
		System.out.format("| |O  C|                                                             |A  R| |%n");
		System.out.format("| |T  O| +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ |L  E| |%n");
		System.out.format("| |A  R| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |b%02d o%02d| |    | |%n",   this.countB(0),this.countO(0),  this.countB(1),this.countO(1),  this.countB(2),this.countO(2),  this.countB(3),this.countO(3),  this.countB(4),this.countO(4),  this.countB(5),this.countO(5));
		System.out.format("| |L  E| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| |r%02d w%02d| | %02d | |%n", this.countR(0),this.countW(0),  this.countR(1),this.countW(1),  this.countR(2),this.countW(2),  this.countR(3),this.countW(3),  this.countR(4),this.countW(4),  this.countR(5),this.countW(5),  this.getScore(1));
		System.out.format("| +----+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +----+ |%n");
		System.out.format("|            0         1         2         3         4        5    PLAYER 1 |%n");
		System.out.format("+---------------------------------------------------------------------------+%n");
	}
	
}