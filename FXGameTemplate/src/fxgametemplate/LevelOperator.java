/*
 * Program:FXGameEngine
 * This:LevelOperator.java
 * Author:Nicholas Johnston
 * Date:6/6/2016
 * Purpose:This accepts the graphic context from the game class and a variable
           used to decide which level to render and display.
           :To add new levels to this create a new object that implements level
            and add a new case to both the switch statments below, one for 
            render and one for tick
            then pass the gc, the t, and the input along
            if you do this you will have made a new renderable level

 */
package fxgametemplate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;


public class LevelOperator 
{
    //variables
    int levelNumber = 0;
    
    //Image robo = new Image("/res/robo1.png");
    LEVELmenu menu = new LEVELmenu();
    LEVELfloatingHeads levelOne = new LEVELfloatingHeads();
    LEVELHitBoxTesting levelTwo = new LEVELHitBoxTesting();
    //constructors
    
    //methods
    public void levelRender( GraphicsContext gc, double t)
    {
        switch(levelNumber)
        {
            case 0:
            {//Render list for main menu
                menu.render(gc, t);
                break;
            }
            case 1:
            {
                levelOne.render(gc,t);
                break;
            }
            case 2:
            {
                levelTwo.render(gc,t);
                break;
            }
        }
    }
    public void levelTick( Input input)
    {
        switch(levelNumber)
        {
            case 0: 
            {
                menu.tick(input);
                if(menu.exit())
                {
                    levelNumber = menu.destination();
                }
                break;
            }
            case 1:
            {
                levelOne.tick(input);
                
                break;
            }
            case 2:
            {
                levelTwo.tick(input);
                break;
            }
            
        }
    }
    
}
