//Antonio Carrion

//Bead Class
public class Bead{

    //Attributes
    protected int precedence;
    protected boolean special;
    protected String color;

    //Default Constructor
    Bead(){
        this.precedence = 0;
        this.special = false;
        this.color = "w";
    }
    
    public int getPrecedence(){
        return this.precedence;
    }
    
    public boolean hasSpecial(){
        return this.special;
    }
    
    public String printColor(){
        return color;
    }
}