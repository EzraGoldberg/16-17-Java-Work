//Author: Ezra Goldberg
import java.util.Scanner;
//import java.util.*;

public class UsingCard{
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    byte valueOfCard=5;
    Card carrdd=new Card("heart",valueOfCard);
    System.out.println("the card's suit is '"+carrdd.getSuit()+"' and its value is "+carrdd.getValue()+".");
    
    String inputtedSuit;
    System.out.println("input a suit for the new card ('spade', 'heart', 'diamond', or 'club'). ");
    inputtedSuit=scanner.nextLine();
    carrdd.setSuit(inputtedSuit);
    
    byte inputtedValue;
    System.out.println("input a value for the new card (an integer from 0 to 13). ");
    inputtedValue=scanner.nextByte();
    carrdd.setValue(inputtedValue);
    
    carrdd=new Card(inputtedSuit, inputtedValue);
    System.out.println("the card's suit is '"+carrdd.getSuit()+"' and its value is "+carrdd.getValue()+".");
    scanner.close();
  }//end of main
}//end of UsingCard