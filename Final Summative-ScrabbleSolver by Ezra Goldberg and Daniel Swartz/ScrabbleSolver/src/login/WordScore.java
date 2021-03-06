package login;
//finds scrabble score of a word
public class WordScore{
  public static int score(String in){
    char[] chars= in.toCharArray();
    arrayToUpper(chars);
    int score=0;
    for(int i=0; i<chars.length; i++){
      score= score+ charScore(chars[i]);
    }
    return score;
  }
  private static void arrayToUpper(char[] in){
    for(int i=0; i<in.length; i++){
      in[i]= Character.toUpperCase(in[i]);
    }
  }
  
  private static int charScore(char a){
    if(a=='A'||a=='E'||a=='I'||a=='O'||a=='N'||a=='R'||a=='T'||a=='L'||a=='S'||a=='U'){
      return 1;
    }
    else if(a=='D'||a=='G'){
      return 2;
    }
    else if(a=='B'||a=='C'||a=='M'||a=='P'){
      return 3;
    }
    else if(a=='F'||a=='H'||a=='V'||a=='W'||a=='Y'){
      return 4;
    }
    else if(a=='K'){
      return 5;
    }
    else if(a=='J'||a=='X'){
      return 8;
    }
    else if(a=='Q'||a=='Z'){
      return 10;
    }
    else{
      return 0;
    }    
  }
}

