/*
 * Program:FXGameTemplate
 * This:FXGameTemplate.java
 * Author:Nicholas Johnston
 * Date:6/5/2016
 * Purpose:This is going to be a defualt fx game template that i will add 
  features to over time
 */
package fxgametemplate;
import javafx.application.Application;
import javafx.stage.Stage;
public class FXGameTemplate extends Application
{

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        Game game = new Game();
        game.run(primaryStage);
    }
    
}
