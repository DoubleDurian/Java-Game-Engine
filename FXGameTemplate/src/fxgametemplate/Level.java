/*
 * Program:FXGameTemplate
 * This:Level.java
 * Author:Nicholas Johnston
 * Date:6/6/2016
 * Purpose:ensures levels have render and tick functions
           as well as an exit function which tells the level operator to leave
           and head to a level address specified in the destination function
           which returns the number
 */
package fxgametemplate;

import javafx.scene.canvas.GraphicsContext;


public interface Level 
{
    
   
    public void render(GraphicsContext gc, double time);
    //renders the item of the level
    public void tick(Input input);
    //activates the logic of the level and causes delta
    public boolean exit();
    //tells the LevelOperator if it should exit to a new stage
    public int destination();
    //tells the LevelOperator which stage to load if exit is true
}
