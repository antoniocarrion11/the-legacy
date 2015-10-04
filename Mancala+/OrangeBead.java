//BlueBead Derived Class
public class OrangeBead extends Bead{
    
    //Default Constructor
    OrangeBead(){
        super.precedence = 3;
        super.special = true;
        super.color = "O";
    }
    
    public void setSpecial(boolean special){
        this.special = special;
    }

}