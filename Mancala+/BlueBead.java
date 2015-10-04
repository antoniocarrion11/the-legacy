//BlueBead Derived Class
public class BlueBead extends Bead{
    
    //Default Constructor
    BlueBead(){
        super.precedence = 1;
        super.special = true;
        super.color = "B";
    }
    
    public void setSpecial(boolean special){
        this.special = special;
    }

}