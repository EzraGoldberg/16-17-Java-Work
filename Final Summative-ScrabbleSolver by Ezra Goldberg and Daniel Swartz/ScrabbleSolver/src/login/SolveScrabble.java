package login;

import login.Word;
import java.io.*;
import java.util.*;
public class SolveScrabble{
  
  public static Word[] ryeBread(String hand)throws Exception{//blame ezra for method name he didnt help
    boolean present=false;
    String line="";
    String[] file=new String[72820];//length of dictionary
    FileReader fr= new FileReader("/Users/EGoldberg/Desktop/EzraGoldbergDanielSwartzFST/dictionary.txt");
    //Filepath for Ezra's computer at school: "/Users/EGoldberg/Desktop/EzraGoldbergDanielSwartzFST/dictionary.txt"
    //Filepath for Ezra's home computer: "C:\\Users\\Owner\\Desktop\\EzraGoldbergDanielSwartzFST\\dictionary.txt"
    BufferedReader br = new BufferedReader(fr);
    int num =0;
    hand=hand.toUpperCase();
    
    while(line!=null){
      line=br.readLine();
      if(line!=null&&num<file.length){
        file[num]=line;
        num++;
      }
    }
    br.close();    
    //System.out.println("read done");
    
    Word[] out=new Word[file.length];
    int q=0;
    for(int i=0; i<file.length; i++){
      for(int j=0; j<hand.length(); j++){
        for(int k=0; k<file[i].length(); k++){    
          if(hand.charAt(j)==Character.toUpperCase(file[i].charAt(k))){
            present=true;
          }
          else if(hand.contains(""+Character.toUpperCase(file[i].charAt(k)))){
          }
          else{
            present=false;
            out[q]=new Word();
            out[q].setWord("~");
            q++;
            j= j+hand.length();
            k= k+file[i].length();
          }
        }
      }
      
      if(present==true){
        out[q]=new Word();
        out[q].setWord(file[i]);
        q++;
      } 
    }
    removeInvalid(out,hand);
    Arrays.sort(out);
    return out;
  }
  private static void removeInvalid(Word[] in, String check){
    //sort hand
    char[] charz = check.toCharArray();
    Arrays.sort(charz);
    int[] checkNums= new int[26];
    for(int i=0; i<charz.length; i++){
      checkNums[Character.getNumericValue(charz[i])-10]++;
    }
    for(int i=0; i<in.length; i++){
      if(!in[i].getWord().equals("~")){
        //sort word
        char[] chars = in[i].getWord().toCharArray();
        Arrays.sort(chars);
        //in[i].setWord(chars.toString());
        
        int[] charNums= new int[26];
        for(int j=0; j<chars.length; j++){
          charNums[Character.getNumericValue(chars[j])-10]++;
        }
        for(int j=0; j<26; j++){
          if(checkNums[j]<charNums[j]){
            in[i].setWord("~");
            break;
          }
        }
        
      }
    }
  }
  
  
  /*private static String replaceChar(String in, int pos){
    String x="";
    if(pos==in.length()-1){
      x= in.substring(0,pos)+"~";
    }
    else{
      x= in.substring(0,pos)+"~"+in.substring(pos+1,in.length());
    }
    //System.out.println(x);
    return x;
  }*/
}