/*
 * Program:FXGameEngine
 * This:LEVELfloatingHeads.java
 * Author:Nicholas Johnston
 * Date:7/4/2016
 * Purpose:This is an experimental debuggin level used to test floating heads
 */
package fxgametemplate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class LEVELfloatingHeads implements Level
{
    //variables
    AnimatedImage AiRobo = new AnimatedImage(10,"robo",.05);
    //constructors
    
    //methods

    @Override
    public void render(GraphicsContext gc, double t) 
    {
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, 1370, 768);
        gc.drawImage(AiRobo.getFrame(t), 20, 20);
        gc.drawImage(AiRobo.getFrame(t), 500, 100, 600, 600);
    }

    @Override
    public void tick(Input input) 
    {
        
    }

    @Override
    public boolean exit() 
    {
        return false;
    }

    @Override
    public int destination() 
    {
        return 0;
    }
    
}
