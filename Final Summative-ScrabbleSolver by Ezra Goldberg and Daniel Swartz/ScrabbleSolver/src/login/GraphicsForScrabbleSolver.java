package login;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GraphicsForScrabbleSolver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Scrabble Solver");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("ScrabbleSolver");
        scenetitle.setFont(Font.font("Lobster 1.4", FontWeight.NORMAL, 36));//Lobster 1.4 is preffered but you'll need to download it, otherwise, use Georgia
        grid.add(scenetitle, 0, 0, 2, 1);

        Text scenesubtitle = new Text("If you give me all the letters you have in Scrabble, I'll print out all the words you can make and how much they're worth.\n                                                                                   (Blank tiles not included)");
        scenesubtitle.setFont(Font.font("Georgia", FontWeight.NORMAL, 16));
        grid.add(scenesubtitle, 0, 0, 2, 6);


        Label pw = new Label("Letters:");
        grid.add(pw, 0, 5);

        TextField pwBox = new TextField();
        grid.add(pwBox, 1, 5);

        Button btn = new Button("Give me words");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 6);
        

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 7);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              //  new secondStage();
                String usersString = pwBox.getText();
                if(usersString.contains(" ")){
                  actiontarget.setFill(Color.CRIMSON);
                  actiontarget.setText("Do not include blank Scrabble tiles");
                }
                else if(usersString.contains("0")||usersString.contains("1")||usersString.contains("2")||usersString.contains("3")||usersString.contains("4")||usersString.contains("5")||usersString.contains("6")||usersString.contains("7")||usersString.contains("8")||usersString.contains("9")||usersString.contains("-")||usersString.contains("_")||usersString.contains("+")||usersString.contains("=")||usersString.contains("!")||usersString.contains("@")||usersString.contains("#")||usersString.contains("$")||usersString.contains("%")||usersString.contains("^")||usersString.contains("&")||usersString.contains("*")||usersString.contains(";")||usersString.contains(":")||usersString.contains("1")||usersString.contains("`")||usersString.contains("~")||usersString.contains("'")||usersString.contains("/")||usersString.contains("?")||usersString.contains(",")||usersString.contains("<")||usersString.contains(">")||usersString.contains(".")){
                  actiontarget.setFill(Color.CRIMSON);
                  actiontarget.setText("Do not include numbers or symbols");
                }
                else if(usersString.equals("")||usersString==null){
                  actiontarget.setFill(Color.CRIMSON);
                  actiontarget.setText("Enter of a string of your Scrabble tiles");
                }
                else{
                  actiontarget.setFill(Color.ROYALBLUE);
                  actiontarget.setText("Currently finding words");
                    try {
                        //secondStageMan(primaryStage,usersString);
                        secondStageWasntWorkingSoThisWillHaveToDo(primaryStage,usersString);
                    } catch (Exception ex) {
                        Logger.getLogger(GraphicsForScrabbleSolver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        Scene scene = new Scene(grid, 1000, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void secondStageWasntWorkingSoThisWillHaveToDo(Stage stage2, String userString) throws Exception {
        stage2.setTitle("Scrabble Solver");
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        //Word [] wordArray= PermsString.ValidWordOut(userString);
        Text scenetitle = new Text("To find the words you can make with the tiles\n'"+userString.toUpperCase()+"'\nplease look at the Compiler's output.");
        scenetitle.setFont(Font.font("Georgia", FontWeight.NORMAL, 24));
        grid2.add(scenetitle, 0, 0, 1, 1);
        Scene disScene = new Scene(grid2, 1000, 400);
        Word [] challahYo= SolveScrabble.ryeBread(userString);
       
        System.out.println("Words you can make with: "+userString.toUpperCase()+" in Scrabble:");

        String [] stringArray= new String [challahYo.length];
        for(int counterrr=0 ; counterrr<stringArray.length ; counterrr++){
          if((challahYo[counterrr].getScore())>0){
            stringArray[counterrr]=challahYo[counterrr].toString();
            System.out.println(/*"stringArray["+counterrr+"] is: "+*/(stringArray[counterrr]));
          }//end of if
        }
        Button btn = new Button("ScrabbleSolve Again");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid2.add(hbBtn, 1, 6);

        final Text actiontarget = new Text();
        grid2.add(actiontarget, 0, 7);
        grid2.setColumnSpan(actiontarget, 2);
        grid2.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            try{start(stage2);
                
            } catch (Exception ex) {
                        Logger.getLogger(GraphicsForScrabbleSolver.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }});
                    
        stage2.setScene(disScene);
        stage2.show(); 
    }//end of secondStageWasntWorkingSoThisWillHaveToDo
//SO the second stage isn't working, but I made this, which is!
    
    public void secondStageMan(Stage secondStage, String userString) throws Exception {
        secondStage.setTitle("Scrabble Solver");
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        //Word [] wordArray= PermsString.ValidWordOut(userString);
        Text scenetitle = new Text("Here are the words you can make with the letters "+userString.toUpperCase()+":");
        scenetitle.setFont(Font.font("Georgia", FontWeight.NORMAL, 24));
        grid2.add(scenetitle, 0, 0, 1, 1);

        Word [] challahYo= SolveScrabble.ryeBread(userString);
        
        String [] stringArray= new String [challahYo.length];
        for(int counterrr=0 ; counterrr<stringArray.length ; counterrr++){
          if((challahYo[counterrr].getScore())>0){
            stringArray[counterrr]=challahYo[counterrr].toString();
            System.out.println("stringArray["+counterrr+"] is: "+(stringArray[counterrr]));
          }//end of if
        }
        
      /*  
      ArrayList<String> arrayListOfWords = new ArrayList<>();
        //ArrayList<String> arrayList= new ArrayList<>(Arrays.asList(stringArray));
        for (String stringArray1 : stringArray) {
          arrayListOfWords.add(stringArray1);
          arrayListOfWords.remove("Word: ~\t\tScore: 0");
          arrayListOfWords.remove(null);
        }
        for (int countar=0 ; countar<arrayListOfWords.size() ; countar++) {
          stringArray[countar]=arrayListOfWords.get(countar);
          System.out.println("stringArray["+countar+"] is: "+(stringArray[countar]));
        }*/
        Scene datScene = new Scene(grid2, 1000, 400);
        Text scenesubtitle1;
        if(stringArray.length==0){
          scenesubtitle1 = new Text("There are no possible words with your letters, sorry!");
          scenesubtitle1.setFont(Font.font("American TypeWriter", FontWeight.BOLD, 12));
          grid2.add(scenesubtitle1, 0, 0, 2, 16);
        }
        else{
          for(int countsaer=16;countsaer<(stringArray.length);countsaer++){
            scenesubtitle1 = new Text(stringArray[countsaer]+"\n");
            scenesubtitle1.setFont(Font.font("American TypeWriter", FontWeight.NORMAL, 16));
            grid2.add(scenesubtitle1, 0, 0, 2, countsaer);
          }
        }//end of else
        
        Button btn = new Button("ScrabbleSolve Again");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid2.add(hbBtn, 1, 6);

        final Text actiontarget = new Text();
        grid2.add(actiontarget, 0, 7);
        grid2.setColumnSpan(actiontarget, 2);
        grid2.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            try{start(secondStage);
                
            } catch (Exception ex) {
                        Logger.getLogger(GraphicsForScrabbleSolver.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }});
        
        secondStage.setScene(datScene);
        secondStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}