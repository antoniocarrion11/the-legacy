/** Description of MainClass  MagicSquare
*   Magic square is the main class where the user inputs the magic square
*   it is parsed and inserted into a 2d array.
*   
*
* @author Antonio Carrion
* @version 1.0
*/
import java.io.*;
import java.util.*;
public class MagicSquare{
	public static void main (String args[]) throws IOException {
        InputStreamReader reader = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (reader);
        
        int firstRow = 0;
        double squareLength;
        double check;
        int rootLength = 0;
        
        /**Prompt the user*/
        System.out.println("Please enter your magic square in sequence.");
        
        /**Collect Input*/
        String userInput = stdin.readLine ();
        
        /**Split Input by space and store into array*/
        String []list = userInput.split ("\\s+");
        
        /**Grab n^2 from array length and n*/
        squareLength = list.length;
        check = Math.sqrt(squareLength);
        
        
        /**Convert double to Int*/
        rootLength = (int) check;
        int squareCheck = (int) squareLength;
        
        System.out.println("Your n^2 is " + squareCheck);
        
        /**Check if squareLength is a perfect Square*/
        if(squareCheck == rootLength*rootLength){
        
            /**Create two dimensional array*/
            int[][] magicSquare = new int [rootLength][rootLength];
            
            /**Parse the input into a 2d array*/
            int t = 0;
            for(int i = 0; i < rootLength; i++){
                for(int j = 0; j < rootLength; j++){
                    magicSquare[i][j] = Integer.parseInt(list[t]);
                    t++;
                }
            }
            
            /**Set first row equal to the sum of the first row*/
            for(int i = 0; i < rootLength; i++){
                firstRow += magicSquare[0][i];
            }
            
            /** Final Check for the magic Square*/
            if(checkRow(magicSquare, rootLength,firstRow)&&
            checkColumn(magicSquare , rootLength,firstRow)&&
            checkDiagonal(magicSquare , rootLength,firstRow)){
                System.out.println("");
                System.out.println("This is a magic Square");
                System.out.println("True");
            }
            else{
                System.out.println("This is not a magic Square");
                System.out.println("false");
            }
            
            
        }
        else{
            System.out.println("The amount of numbers that you entered cannot be square rooted evenly.");
            System.out.println("false");
        }
    
    }
    
    /** Description of checkRow(int array, int n, int firstRow), checkColumn, and checkDiagonal
     *  checkRow adds up the indicies inside it's corresponding element in the 2d array.
     *  Each element in the 2d array acts as a Row in the magic square, which each index being a value.
     *  checkColumn takes the first value of all the Rows and adds them up to get the first Coulmn value 
     *  and continues that process until there are no more values in each Row.
     *  checkDiagonal adds up the Diagonals in this specific order: [0][0],[1][1]...[n][n] for the first Diagonal value.
     *  and: [0][3],[1][2],[2][1]... [(0+1)< n][(n-1)-1 >= 0] for the second Diagonal Value. There are only 2 Diagonal values in a square.
	 * 
	 * @param array     array is a 2d array that represents the sequence of numbers the user entered
	 * @param n		    n is the dimension of the "Square" that we are testing
     * @param firstRow  firstRow is the number that the values in the corresponding columns should add up to
	 * @return			returns a boolean value
	 */
    
    public static boolean checkRow(int array[][],int n,int firstRow){
            
        int AllRow = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){ 
                AllRow += array[i][j];
            }
        }
       
       if (n*firstRow == AllRow)
            return true;
       
       else
            return false;
            
    }
        
    public static boolean checkColumn(int array[][],int n,int firstRow){

        int allRow = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){ 
                allRow += array[j][i];
            }
        }
        
       if (n*firstRow == allRow)
           return true;
       
       else
           return false;
            
    }
    
    public static boolean checkDiagonal(int array[][],int n,int firstRow){
        int diagonals = 0;
        
        for (int i = 0; i < n; i++){
            diagonals += array[i][i];
        }
        
        int t = n-1;
        for (int i = 0; i < n; i++){
            diagonals += array[i][t];
            t--;
        }
        
        if(firstRow*2 == diagonals)
            return true;
            
        else
            return false;

    }

}