//Author: Ezra Goldberg
/*Design Section:Card IS A(N):Object , HAS A(N):String suit, byte value , and RESPONDS TO:getSuit(),getValue(),setSuit(suit), and setValue(value).
 *How to use the class and methods:
   *the class Card shouldn't be used by the user at all
     *the method getSuit() will be used by UsingCard.java to obtain the card's suit. This would not be needed if suit wasn't encapsulated (private)
     *the method getValue() is the same as getSuit() but for value
     *the method setSuit() will be used by UsingCard.java to check if the inputted suit will work. It does this by conatining an if statement to check if the inputted suit is one of the four accepted values and if it isn't, an error is thrown
     *the method setValue() is the same as setSuit() but for value, and there are 14 accepted values: 1=ace, 11=jack, 12=queen, 13= king, 0=joker, and 2 to 10 are 2 to 10
   *the class UsingCard and its main method will be used by the user to read the card's information, change the information, and read the card's info again
 *Classes work when:
   *the class Card will always work since it runs the way it is supposed to and has no user interaction
   *the class UsingCard will technicallly always work because if the user inputs any data that is bad (e.g. suit="dfg", value=23)
   *then when the check is done, setSuit or setValue will throw an error. If user enters horrible data (e.g. value=sdf, value=200)
   *then the program will crash automatically. Because of these forced crashes, the class will always work when it doesn't crash.
*/
import java.io.*; 
import java.util.Scanner;

public class Card{//could write 'extends Object' here but dont need to
  private String suit;//not static to simplify life
  private byte value;//not static to simplify life
  
  public Scanner scanner=new Scanner(System.in);
  public static void main (String[]args)throws IOException, Exception{
  }//end of main method*/
  
  public Card(){//MUST have same name as class - Constructor method
    suit= "Spade";
    value=12;
  }//end of Card
  
  public Card(String suit, byte value){//2nd constructor method with same name//if you wanted to name the variables name and salary, see the below comments for correct code
    this.suit=suit;
    this.value=value;
  }//end of Card
  
  public String getSuit (){
  return suit;
  }
  
  public byte getValue(){
    return value;
  }
  
  public void setSuit (String suitofDaCard){
    if (suitofDaCard.equalsIgnoreCase("spade")||suitofDaCard.equalsIgnoreCase("club")||suitofDaCard.equalsIgnoreCase("heart")||suitofDaCard.equalsIgnoreCase("diamond")){
    }    else{throw new NullPointerException();}
  }//end of setSuit
  
  public void setValue(byte valueofDaCard){
    if (valueofDaCard==1||valueofDaCard==2||valueofDaCard==3||valueofDaCard==4||valueofDaCard==5||valueofDaCard==6||valueofDaCard==7||valueofDaCard==8||valueofDaCard==9||valueofDaCard==10||valueofDaCard==11||valueofDaCard==12||valueofDaCard==13||valueofDaCard==0){
    }    else{throw new NullPointerException();}
  }//end of setValue
 
}//end of class