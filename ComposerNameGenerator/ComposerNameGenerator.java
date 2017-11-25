//Author: Ezra Goldberg
//Date created: Thursday September 15th, 2016
//Date last modified: Tuesday Sept 27th, 2016
import java.util.Scanner;

public class ComposerNameGenerator{
  public static void main (String[]args){
    Scanner scanner=new Scanner(System.in);
    String[][]mDA={{"Ludwig","Johann","Georg","Richard","Joseph","Franz","Robert","Sergei","Giovanni","Wolfgang","Gustav","Igor","Frederic","Felix","Piotr"},{"Bach","Beethoven","Haydn","Rachmaninoff","Mendelssohn","Wagner","Mahler","Mozart","Chopin","Tchaikovsky"}};
    String originalFirstName="", originalLastName="";
    boolean doWeHaveToRedoThat=false;
    
    do{
      if(doWeHaveToRedoThat==true){System.out.println("That is not valid first name \nEnter your first name:");}
      else{System.out.println("Welcome to ComposerNameGenerator! You'll enter your first and last name, and I'll spit out your composer name! \nEnter your first name:");}
      try{        originalFirstName=scanner.nextLine();      }
      catch(Exception e){              }//end of catch
     if(originalFirstName.equalsIgnoreCase("")){doWeHaveToRedoThat=true;}
     else{doWeHaveToRedoThat=false;}
    }while(doWeHaveToRedoThat==true);//end of while loop for first name selection
    
    do{
      if(doWeHaveToRedoThat==true){System.out.println("That is not valid last name \nEnter your last name:");}
      else{System.out.println("Enter your last name:");}
      try{        originalLastName=scanner.nextLine();        }//end of try
      catch(Exception e){      }//end of catch
      if(originalLastName.equalsIgnoreCase("")){doWeHaveToRedoThat=true;}
      else{doWeHaveToRedoThat=false;}
    }while(doWeHaveToRedoThat==true);//end of while loop for last name selection
    
    int oFNRemainder=(originalLastName.length())%2;//divides by 2 and takes the remainder, thus divides the 10 possible last names into 5 for those who divide evenly into 2 pieces, and those who don't and have a remainder
    char initial=originalFirstName.charAt(0);
    String stringThatWasInitial= String.valueOf(initial);
    
    int whichName=0;
    if(stringThatWasInitial.equalsIgnoreCase("a")||stringThatWasInitial.equalsIgnoreCase("u")){      whichName=0;    }
    else if(stringThatWasInitial.equalsIgnoreCase("j")){      whichName=1;    }
    else if(stringThatWasInitial.equalsIgnoreCase("d")){      whichName=2;    }
    else if(stringThatWasInitial.equalsIgnoreCase("n")||stringThatWasInitial.equalsIgnoreCase("v")){      whichName=3;    }
    else if(stringThatWasInitial.equalsIgnoreCase("t")||stringThatWasInitial.equalsIgnoreCase("q")){      whichName=4;    }
    
    else if(stringThatWasInitial.equalsIgnoreCase("m")||stringThatWasInitial.equalsIgnoreCase("y")){      whichName=5;    }
    else if(stringThatWasInitial.equalsIgnoreCase("c")){      whichName=6;    }
    else if(stringThatWasInitial.equalsIgnoreCase("l")){      whichName=7;    }
    else if(stringThatWasInitial.equalsIgnoreCase("r")||stringThatWasInitial.equalsIgnoreCase("i")){      whichName=8;    }
    else if(stringThatWasInitial.equalsIgnoreCase("g")||stringThatWasInitial.equalsIgnoreCase("f")){      whichName=9;    }
    
    else if(stringThatWasInitial.equalsIgnoreCase("e")||stringThatWasInitial.equalsIgnoreCase("x")){      whichName=10;    }
    else if(stringThatWasInitial.equalsIgnoreCase("s")){      whichName=11;    }
    else if(stringThatWasInitial.equalsIgnoreCase("k")){      whichName=12;    }
    else if(stringThatWasInitial.equalsIgnoreCase("b")||stringThatWasInitial.equalsIgnoreCase("h")){      whichName=13;    }
    else if(stringThatWasInitial.equalsIgnoreCase("w")){      whichName=14;    }
    else{      whichName=14;    }
  
    //these weird divides between letters is based on what letters are most often first name initials according to this:
    //http://www.nancy.cc/2014/05/12/popular-first-letters-2013/
    //all so that the names would appear about as often
    //A,J,e,N,T,V,Q,U | M,C,L,R,G,I,F,Y | d,S,K,B,D,H,W,X
    
    int firstNameValue=((whichName)-1);
    
    initial=originalLastName.charAt(0);
    stringThatWasInitial= String.valueOf(initial);
    if(oFNRemainder==0){
      whichName=LastNameCalculator(stringThatWasInitial);//last names whose length is divisable by 2 are names 0 to 4 of the array
    }//end of if statement for remainder equaling 0
    else if(oFNRemainder==1){
      whichName=(LastNameCalculator(stringThatWasInitial)+5);//last names whose length isn't divisable by 2 are names 5 to 9 of the array
    }//end of if statement for remainder equaling 1
    int lastNameValue=whichName;
    System.out.println("Your composer name is "+mDA[0][firstNameValue]+" "+mDA[1][lastNameValue]+".");
    scanner.close();//this was just to get rid of a warning that Dr. Java gave me
  }//end of main method
  public static int LastNameCalculator(String initial){
    int whichName=5;
    
    if(initial.equalsIgnoreCase("a")||initial.equalsIgnoreCase("u")||initial.equalsIgnoreCase("m")||initial.equalsIgnoreCase("y")){      whichName=0;    }
    else if(initial.equalsIgnoreCase("j")||initial.equalsIgnoreCase("d")||initial.equalsIgnoreCase("c")||initial.equalsIgnoreCase("x")||initial.equalsIgnoreCase("b")){      whichName=1;    }
    else if(initial.equalsIgnoreCase("d")||initial.equalsIgnoreCase("w")||initial.equalsIgnoreCase("l")||initial.equalsIgnoreCase("e")||initial.equalsIgnoreCase("h")){      whichName=2;    }
    else if(initial.equalsIgnoreCase("n")||initial.equalsIgnoreCase("v")||initial.equalsIgnoreCase("s")||initial.equalsIgnoreCase("r")||initial.equalsIgnoreCase("i")){      whichName=3;    }
    else if(initial.equalsIgnoreCase("t")||initial.equalsIgnoreCase("q")||initial.equalsIgnoreCase("k")||initial.equalsIgnoreCase("g")||initial.equalsIgnoreCase("f")){      whichName=4;    }
    else {      whichName=0;    }
    
    return whichName;
  }//end of method LastNameCalculator
}//end of class


