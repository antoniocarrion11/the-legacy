
public class Player{

    //Attributes
    private    int      id;
    protected  String   name;
    protected  int      wins;

    //Default Constructor
    Player(){
        this.id = 0;
        this.name = "";
        this.wins = 0;
    }
    
    Player(int newID, String newName){
      this.id = newID;
      this.name = newName;
      this.wins = 0;
    }
    
    public int getID(){
      return this.id;
    }
    
    public String getName(){
      return this.name;
    }
    
    public int getWins(){
      return this.wins;
    }
    
    public void setWins(){
      this.wins = this.wins++;
    }
}