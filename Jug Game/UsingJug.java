//Author: Ezra Goldberg
//Date created: 
import java.io.*; 
import java.util.Scanner;

public class UsingJug extends Jug{//could write 'extends Object' here but dont need to

  public static Scanner scanner=new Scanner(System.in);
  public static void main (String[]args)throws IOException, Exception{
    Jug jug1=new Jug(8,8);
    Jug jug2=new Jug(0,5);
    Jug jug3=new Jug(0,3);    
      
    System.out.println("Welcome to Jug Game, Ezra Goldberg's program that simulates a fun puzzle involving the following three jugs:"); Thread.sleep(800);
    statusReportOfJugs(jug1,jug2,jug3);
    System.out.println("Your goal is to end up with 4L in Jug1 and Jug2.");
    selectingWhichJugsToPour(jug1,jug2,jug3);
    
  }//end of main method
  
  public static void selectingWhichJugsToPour(Jug jug1, Jug jug2,Jug jug3)throws InterruptedException{
    int numOfJugToPourOut=4;
    int numOfJugToPourInto=4;
    do{
      try{
        System.out.println("Enter the number of the jug you want to pour FROM (1,2, or 3)");
        numOfJugToPourOut=scanner.nextInt();
        System.out.println("Enter the number of the jug you want to pour INTO (1,2, or 3)");
        numOfJugToPourInto=scanner.nextInt();
      }//end of try
      catch(Exception e){throw new NullPointerException("That was not a number");}//end of catch
      if(numOfJugToPourOut==numOfJugToPourInto){
        numOfJugToPourInto=4;
        System.out.println("Cannot pour FROM and INTO the same jug,\ntry again");
      }//end of if
    }while(numOfJugToPourOut>3||numOfJugToPourInto>3||numOfJugToPourOut<1||numOfJugToPourInto<1);//makes it so user cant input jugs that dont exist such as jug0 or jug4
    pouringAndTellingUser(numOfJugToPourOut,numOfJugToPourInto, jug1, jug2, jug3);
  }//end of selectingWhichJugsToPour
  
  public static void pouringAndTellingUser(int numOfJugToPourOut, int numOfJugToPourInto, Jug jug1, Jug jug2,Jug jug3)throws InterruptedException{
    if(numOfJugToPourOut==1&&numOfJugToPourInto==2){jug1.pourInto(jug2);}
    else if(numOfJugToPourOut==1&&numOfJugToPourInto==3){jug1.pourInto(jug3);}
    else if(numOfJugToPourOut==2&&numOfJugToPourInto==1){jug2.pourInto(jug1);}
    else if(numOfJugToPourOut==2&&numOfJugToPourInto==3){jug2.pourInto(jug3);}
    else if(numOfJugToPourOut==3&&numOfJugToPourInto==1){jug3.pourInto(jug1);}
    else if(numOfJugToPourOut==3&&numOfJugToPourInto==2){jug3.pourInto(jug2);}
    statusReportOfJugs(jug1,jug2,jug3);
    determiningIfUserWillPourAgain(jug1,jug2,jug3);
  }//end of pouringAndTellingUser

  public static void determiningIfUserWillPourAgain(Jug jug1, Jug jug2, Jug jug3)throws InterruptedException{
    checkToSeeIfWon(jug1, jug2, jug3);
    selectingWhichJugsToPour(jug1, jug2, jug3);
  }//end of determiningIfUserWillPourAgain
  
  public static void checkToSeeIfWon(Jug jug1, Jug jug2, Jug jug3)throws InterruptedException{
    String status=("("+jug1.getCurrentVolume()+","+jug1.getMaxVolume()+")("+jug2.getCurrentVolume()+","+jug2.getMaxVolume()+")("+jug3.getCurrentVolume()+","+jug3.getMaxVolume()+")");
    if(status.equals("(4,8)(4,5)(0,3)")){
      System.out.println("\n\n\n\n\n\n\n\n************************************************************************"+
                         "\n            Y O U   W O N ,   C O N G R A T U L A T I O N S\n"+
                         "************************************************************************\n");
      Thread.sleep(5500);
      System.out.println("by the way you can like quit this at like any time now, the game is over");
      Thread.sleep(6500);
      System.out.print(".");Thread.sleep(300);System.out.print(".");Thread.sleep(300);System.out.print(".");System.out.print(".");Thread.sleep(300);System.out.print(".");
      Thread.sleep(1000);
      System.out.print("Like seriously?");
      Thread.sleep(500);
      System.out.println("\nwell");
      Thread.sleep(2500);
      System.out.println("The program is gonna crash in");
      Thread.sleep(999);System.out.println("5");Thread.sleep(999);System.out.println("4");Thread.sleep(999);System.out.println("3");Thread.sleep(999);System.out.println("2");Thread.sleep(999);System.out.println("1");Thread.sleep(999);
      throw new NullPointerException("You won but you took too long to stop the program.");
    }//end of if for winning
  }//end of check to see if won
  
  public static void statusReportOfJugs(Jug jug1, Jug jug2, Jug jug3)throws InterruptedException{//like toString but prints out with Thread.sleep instead of returnintg it
    System.out.println("Jug1: "+jug1.getCurrentVolume()+"L/8L");Thread.sleep(400);
    System.out.println("Jug2: "+jug2.getCurrentVolume()+"L/5L");Thread.sleep(400);
    System.out.println("Jug3: "+jug3.getCurrentVolume()+"L/3L");Thread.sleep(400);
  }//end of statusReportOfJugs
}//end of class