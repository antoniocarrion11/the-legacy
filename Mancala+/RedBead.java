//BlueBead Derived Class
public class RedBead extends Bead{
    
    //Default Constructor
    RedBead(){
        super.precedence = 2;
        super.special = true;
        super.color = "R";
    }
    
    public void setSpecial(boolean special){
        this.special = special;
    }

}