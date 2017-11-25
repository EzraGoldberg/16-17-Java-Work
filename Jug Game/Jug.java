//Author: Ezra Goldberg
//Date created: 
import java.io.*; 

public class Jug{//could write 'extends Object' here but dont need to
  private int currentVolume;//not static to simplify life
  private int maxVolume;//not static to simplify life
  
  public static void main (String[]args)throws IOException, Exception{
  }//end of main method
  
  public Jug(){//MUST have same name as class - Constructor method
    currentVolume= 4;
    maxVolume=8;
  }//end of Jug
  
  public Jug(int currentVolume, int maxVolume){//2nd constructor method with same name//if you wanted to name the variables name and salary, see the below comments for correct code
    this.maxVolume=maxVolume;
    this.currentVolume=currentVolume;
  }//end of Jug
  
  public int getCurrentVolume (){
    return this.currentVolume;
  }//end of getCurrentVolume
  
  public int getMaxVolume (){
    return this.maxVolume;
  }//end of getMaxVolume
  
  
  public void setCurrentVolume(int newCurrentVolumeOfDaJug){
    if(newCurrentVolumeOfDaJug>=0&&newCurrentVolumeOfDaJug<=maxVolume){
      currentVolume=newCurrentVolumeOfDaJug;
    }//end if
    else{
      throw new NullPointerException("Sorry pal, you're gonna need to input a valid current volume.");
    }//end else
  }//end setCurrent
  
  public void setMaxVolume(int newMaxVolumeOfDaJug){
    if(newMaxVolumeOfDaJug>0){
      maxVolume=newMaxVolumeOfDaJug;
    }//end if
    else{
      throw new NullPointerException("Sorry pal, you're gonna need to input a positive integer.");
    }//end else
  }//end setMaxVolume

  public void pourInto(Jug juuug){//j1.pourInto(j2);

    while(this.getCurrentVolume()>0 && juuug.getCurrentVolume()<juuug.getMaxVolume()){
      this.setCurrentVolume(this.getCurrentVolume()-1);
      juuug.setCurrentVolume(juuug.getCurrentVolume()+1);
    }//end of while
  }//end of pourInto
  
}//end of class
