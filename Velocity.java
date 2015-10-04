import java.text.*;
import java.io.*;

public class Velocity {

    public static void main (String args[]) throws IOException {
		InputStreamReader reader = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (reader);
        
        double time;
        double height;
        double rads;
        
        System.out.print("Prompt: ");
        String str = stdin.readLine();
        String input [] = str.split ("\\s+");
        
        double velocity = Double.parseDouble (input [0]);
        double angle = Double.parseDouble (input [1]);
        double distance = Double.parseDouble (input [2]);
        double size = Double.parseDouble (input [3]);
        double elevation = Double.parseDouble (input [4]);     
        
        while (velocity != 0.0 && angle != 0.0 && distance != 0.0 && size != 0.0 && elevation != 0.0){
        
            System.out.println("The projectile's velocity is " + velocity + " feet per second");
            System.out.println("The angle of elevation is " + angle + " degrees");
            System.out.println("The distance to the target is " + distance + " feet");
            System.out.println("The size of the target is " + size + " feet");
            System.out.println("The elevation of the target is "+ elevation + " feet");
            System.out.println("");
        
            rads = Math.toRadians(angle);
            time = (distance / (velocity * Math.cos (rads)));
            height = (velocity * time * Math.sin (rads) - (32.17 * time * time) / 2.0);
        
            if ((height >= elevation) && (height <= elevation + size)){
                System.out.println ("The target was hit by the projectile");}
            else if ((height >= 0 )&& (height < elevation))
                    System.out.println ("The projectile was too low, height was: " +(height) + " feet");
            else if (height >= elevation + size)
                    System.out.println ("The projectile was too high, height was: " +(height) + " feet");
            else
                    System.out.println ("The computed distance was too short to reach the target");
          
            str = stdin.readLine ();
            input = str.split ("\\s+");
            velocity = Double.parseDouble (input [0]);
            angle = Double.parseDouble (input [1]);
            distance = Double.parseDouble (input [2]);
            size = Double.parseDouble (input [3]);
            elevation = Double.parseDouble (input [4]);  
        }
    }
}