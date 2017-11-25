//Name:    BinarySearch
//Author:  Ezra Goldberg
//Date:    Feb 27th, 2017
//Purpose: to test whether the target (userNum) is in the array, and to run this search multiple times to check how long it takes

import java.util.*;

public class BinarySearch{
  
  public static Scanner scanner=new Scanner(System.in);
  
  public static void main(String[] args){
    introduction();
  }//end of main
  
  public static void introduction(){
    int lengthOfArray;
    System.out.println("Enter the length of the list:");
    try{lengthOfArray=scanner.nextInt();}//end of try
    catch(Exception e){throw new NullPointerException("That was not a number");}//end of catch
    if(lengthOfArray<2){
      throw new NullPointerException("Lists need to be at least two elements long, silly.");
    }//end if
    int userNum = -1;  
      /*This is commented out so that userNum is never in the array, to time the max search time,
        can be uncommented for more user input
    System.out.println("Enter the number you want to find:");
    try{userNum=scanner.nextInt();}//end of try
    catch(Exception e){throw new NullPointerException("That was not a number");}//end of catch
  //*/
    //testingOutBinarySearch(userNum, lengthOfArray);//uncomment THIS line to use testingOutBinarySearch
    searchLoop(userNum, lengthOfArray);
  }//end of introduction
  
  public static void testingOutBinarySearch(int userNum, int lengthOfArray){//this method is here so you can check that the 
    int[] intArray = new int [lengthOfArray];          //binarySearch method returns the right answer, 
    for (int i = 0; i < lengthOfArray; i++){                 //to use it by un-commenting out the line in introduction.
      intArray[i]=i;
      //System.out.println("intArray["+i+"] is: "+intArray[i]+".");//This was just to test it
    }//end of for
    int positionOfUserNum = binarySearch(intArray, 0, (lengthOfArray-1), userNum);
    if(positionOfUserNum==-1){System.out.println(userNum+" was not found in the array.");}
    else{System.out.println(userNum+" was found in element number "+positionOfUserNum+" of the array.");}
  }//end of testingOutBinarySearch
  
  public static void searchLoop(int userNum, int lengthOfArray){
    int[] intArray = new int [lengthOfArray];
    for (int i = 0; i < lengthOfArray; i++){//fills intArray with numbers 0,1,2,3,...(lengthOfArray-1)
      intArray[i]=i;
    }//end of for
    int numOfTimesToRunDaSearch;
    System.out.println("Enter the number of times to run the search:");
    try{numOfTimesToRunDaSearch=scanner.nextInt();}//end of try
    catch(Exception e){throw new NullPointerException("That was not a number");}//end of catch
    if(numOfTimesToRunDaSearch<100){
      throw new NullPointerException("Binary Search needs to be run at least 100 times.");
    }//end if
    
    Date t1=new Date();
    for(int i=0;i<numOfTimesToRunDaSearch;i++){
      binarySearch(intArray, 0, (lengthOfArray-1), userNum);
    }//end of for
    Date t2=new Date();
    long time=(t2.getTime()-t1.getTime());
    System.out.println("took "+time+" milisecond(s).");
    determiningIfUserWillTryAgain(userNum, lengthOfArray);
  }//end of searchLoop
  
  public static int binarySearch(int[ ] arrayOfDemNumbers, int startingPointOfArray, int endingPointOfArray, int userNum) {
    int middle = (startingPointOfArray + endingPointOfArray) / 2;
    if(endingPointOfArray < startingPointOfArray){return -1;}//base case for starting point being larger than ending point
    if(userNum==arrayOfDemNumbers[middle]){return middle;}//base case for userNum being middle of array
    else if(userNum<arrayOfDemNumbers[middle]){
      return binarySearch(arrayOfDemNumbers, startingPointOfArray, middle - 1, userNum);
    }//end of else if
    else{//this is an else and not else if because binarySearch has to return an int
      return binarySearch(arrayOfDemNumbers, middle + 1, endingPointOfArray, userNum);
    }//end of else
  }//end of binarySearch
  
  public static void determiningIfUserWillTryAgain(int userNumber, int lengthOfDaArray){
    String userResponseNumba1="";
    String userResponseNumba2="";
    System.out.println("Would you like to try searching again? (Y/N)");
    while(userResponseNumba1==""){
      try{userResponseNumba1=scanner.nextLine();}//end of try
      catch(Exception e){throw new NullPointerException("That was not a 'Y' or a 'N'");}//end of catch
      if (userResponseNumba1.equalsIgnoreCase("Y")||userResponseNumba1.equalsIgnoreCase("YES")||userResponseNumba1.equalsIgnoreCase("YEP")||userResponseNumba1.equalsIgnoreCase("YEAH")||userResponseNumba1.equalsIgnoreCase("YEH")){
        System.out.println("Would you like to keep the array the same size? (Y/N)");
        while(userResponseNumba2==""){
          try{userResponseNumba2=scanner.nextLine();}//end of try
          catch(Exception e){throw new NullPointerException("That was not a 'Y' or a 'N'");}//end of catch
          if (userResponseNumba2.equalsIgnoreCase("Y")||userResponseNumba2.equalsIgnoreCase("YES")||userResponseNumba2.equalsIgnoreCase("YEP")||userResponseNumba2.equalsIgnoreCase("YEAH")||userResponseNumba2.equalsIgnoreCase("YEH")){
            searchLoop(userNumber, lengthOfDaArray);
          }
          else if (userResponseNumba2.equalsIgnoreCase("N")||userResponseNumba2.equalsIgnoreCase("NO")||userResponseNumba2.equalsIgnoreCase("NOPE")||userResponseNumba2.equalsIgnoreCase("NOT TODAY")||userResponseNumba2.equalsIgnoreCase("NAH")){
            introduction();
          }
          else{userResponseNumba2="";}
        }//end of while        
      }//end of if for Choosing to search again
      else if (userResponseNumba1.equalsIgnoreCase("N")||userResponseNumba1.equalsIgnoreCase("NO")||userResponseNumba1.equalsIgnoreCase("NOPE")||userResponseNumba1.equalsIgnoreCase("NOT TODAY")||userResponseNumba1.equalsIgnoreCase("NAH")){
        printingTable();
      }//end of Choosing to not search again
      else{userResponseNumba1="";}
    }//end of while
  }//end of determiningIfUserWillPourAgain
  
  public static long searchLoopButNoUserInput(int numOfTimesToRunDaSearch, int lengthOfArray){
    int[] intArray = new int [lengthOfArray];
    for (int i = 0; i < lengthOfArray; i++){intArray[i]=i;}//fills intArray with numbers 0,1,2,3,...(lengthOfArray-1).
    Date t1=new Date();
    for(int j=0;j<numOfTimesToRunDaSearch;j++){
      binarySearch(intArray, 0, (lengthOfArray-1), -1);
    }//end of for
    Date t2=new Date();

    return (t2.getTime()-t1.getTime());
  }//end of searchLoopButNoUserInput*/
  
  public static void printingTable(){//counterUsedInDaSizeOfTheArray
    for (int counterUsedInDaSizeOfTheArray=2;counterUsedInDaSizeOfTheArray<129;counterUsedInDaSizeOfTheArray=(counterUsedInDaSizeOfTheArray*2)){
      System.out.println("For a "+(int)counterUsedInDaSizeOfTheArray+" element array:");
      System.out.print("Number of\t\tNumber of\ntimes the\t\tmiliseconds\nsearch was\t\tthe search\nrun:\t\ttook:\n");
      int powerOfTen=-1;
      for(double counterThatsNumOfTimesToDoSearch=4.0;counterThatsNumOfTimesToDoSearch<8.0;counterThatsNumOfTimesToDoSearch++){
        powerOfTen=(int)(Math.pow(10.0,counterThatsNumOfTimesToDoSearch));
        System.out.print(powerOfTen+"\t\t"+searchLoopButNoUserInput(powerOfTen, 64)+"\n");
      }//end of for
      System.out.print("\n");
    }//end of for
  }//end of printingTable
  
}//end of BinarySearch