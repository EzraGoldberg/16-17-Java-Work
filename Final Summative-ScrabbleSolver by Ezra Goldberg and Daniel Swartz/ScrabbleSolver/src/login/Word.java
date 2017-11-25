package login;



//basic object word with String and score
public class Word implements Comparable{
  private String word="";
  private int score=0;
  
  public Word(){
  }
  
  public void setWord(String in){
    if(in!=null){
      word=in;
      setScore();
    }
  }
  private void setScore(){
    this.score= WordScore.score(word);
  }
  
  public String getWord(){
    return word;
  }
  
  public int getScore(){
    return score;
  }
  
  public int compareTo(Object o){
    Word w= (Word) o;
    if (this.score!=w.score){
      return (int)(w.score-this.score);
    }
    else{
      return this.word.compareTo(w.word);
    }
  }
  
  public String toString(){
    return ("Word: "+word+"\t\tScore: "+score);
  }
  
}//end class