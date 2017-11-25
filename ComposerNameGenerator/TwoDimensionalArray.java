//Author: Ezra Goldberg
//Date created: Tuesday September 13th, 2016
import java.util.Random;

public class TwoDimensionalArray{
  public static void main (String[]args){
    int[][]twoDimensionalArray=new int [3][5];
    
    
    for(int i=0;i<3;i++){
      for(int counter=0;counter<5;counter++){
        Random rand = new Random();
        int  randomInt = rand.nextInt(50) + 1;
        twoDimensionalArray[i][counter]=randomInt;
        System.out.println("twoDimensionalArray["+i+"]["+counter+"] is "+twoDimensionalArray[i][counter]+".");
      }//end of for loop 2
    }//end of for loop 1
    
  }//end of main method
  
  
}//end of class

