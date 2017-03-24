/*
 * Program:
 * This:
 * Author:
 * Date:
 * Purpose:
 */
package fxgametemplate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Nick Johnston
 */
public class LEVELmenu implements Level
{
    //variables
    int cursorPos =2;
    boolean shouldExit = false;
    boolean toggle = true;
    //constructor
    
    //methods
    
    //Override methods

    @Override
    public void render(GraphicsContext gc, double time) 
    {
        gc.setFill(Color.CORNSILK);
        gc.fillRect(0, 0, 1360, 768);
        gc.setFill(Color.CRIMSON);
        gc.setFont(new Font( 50));
        gc.setTextAlign(TextAlignment.CENTER);
        //note to self, attempt to load in pre made font using font.loadFont()
        //will require an input stream
        gc.fillText("Nick Johnston's Spectacular Java Engine", 670, 70);
        
        gc.setFont(new Font(30));
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText("Floating Animated Heads Gallery", 600, 250);
        gc.fillText("Hit Box Ballistics lab",600,300);
        
        gc.fillText(""+cursorPos, 600, 350);
        switch(cursorPos)
        {
            case 1: 
            {
                gc.fillRect(540, 230, 20, 20);
                break;
            }
            case 2:
            {
                gc.fillRect(540, 280, 20, 20);
                break;
            }
            
        }
        
        
        
    }

    @Override
    public void tick(Input input) 
    {//this is for controlling the cursor that selects which level to display
        if(input.up && toggle)
        {
            cursorPos --;
            toggle = false;
        }
        if(input.down && toggle)
        {
            cursorPos++;
            toggle = false;
        }
        if(!input.down && !input.up)
        {
            toggle = true;
        }
        if(input.space)
        {
            shouldExit = true;
        }
    }

    @Override
    public boolean exit() 
    {
        return shouldExit;
    }

    @Override
    public int destination() 
    {
        return cursorPos;
    }
    
}
