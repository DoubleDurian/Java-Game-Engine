/*
 * Program:FXGameTemplate
 * This:EntityBox.java
 * Author:Nicholas Johnston
 * Date:7/19/2016
 * Purpose:This holds a DeltaBox and  HitBox and binds the two together as one
           entity that moves and hit detects
 */
package fxgametemplate;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Nick Johnston
 */
public class EntityBox 
{
    //variables
    DeltaBox primaryDeltaBox;
    HitBox primaryHitbox;
    
    
    //CollisionQueue enemyQueue;
    //CollisionQueue levelQueue;
    int xPos;
    int yPos;
    
    int xSize;
    int ySize;
    
    int xLim;
    int yLim;
    int xMin;
    int yMin;
    //constructor
    public EntityBox(int xPos, int yPos, int xSize, int ySize, int xLim, int yLim)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        this.xLim = xLim;
        this.yLim = yLim;
        primaryDeltaBox = new DeltaBox(xPos,yPos,xSize,ySize,xLim,yLim);
        primaryHitbox = new HitBox(xPos,yPos,xSize,ySize);
       
        //enemyQueue = new CollisionQueue();
        //levelQueue = new CollisionQueue();
    }
    //methods
    public void setLevel(CollisionQueue level)
    {
        //this.levelQueue = level;
        primaryDeltaBox.addLevel(level);
    }
    public void setEnemy(CollisionQueue enemy)
    {
        //this.enemyQueue = enemy;
        primaryDeltaBox.addEnemy(enemy);
    }
    public void updatePos()
    {//should be called in the tick method
        //pull this entityBox's new location from the deltaBox
        
        xPos = primaryDeltaBox.deltaX(primaryHitbox,1);
        yPos = primaryDeltaBox.deltaY(primaryHitbox,1);
        //pass the new position onto the hitBox//
        primaryHitbox.setLoc(xPos, yPos, xSize, ySize);
        
    }
    public void render(GraphicsContext gc, double t)
    {
        
    }
    public void debugRender(GraphicsContext gc, double t)
    {
        //render the internal box
        if(isHit()||isTouch())
        {
            //if it is hit
            gc.setStroke(Color.YELLOW);
            
        }
        else
        {
            //if it isnt
            gc.setStroke(Color.GREEN);
            
        }
        gc.strokeRect(xPos, yPos, xSize, ySize);
        //render the lines that form the outside of the box
        //the next step is to render the valence hitboxes.
        if(leftHit()||leftTouch())
        {
            gc.setStroke(Color.RED);
        }
        else
        {
            gc.setStroke(Color.BLUE);
        }
        gc.strokeRect(primaryHitbox.LEFTupperLeftX, 
                primaryHitbox.LEFTupperLeftY, primaryHitbox.xSize, 
                primaryHitbox.ySize);
        
        if(rightHit()||rightTouch())
        {
            gc.setStroke(Color.RED);
        }
        else
        {
            gc.setStroke(Color.BLUE);
        }
        gc.strokeRect(primaryHitbox.RIGHTupperLeftX, 
                primaryHitbox.RIGHTupperLeftY, primaryHitbox.xSize, 
                primaryHitbox.ySize);
        if(upperHit()||upperTouch())
        {
            gc.setStroke(Color.RED);
        }
        else
        {
            gc.setStroke(Color.BLUE);
        }
        gc.strokeRect(primaryHitbox.UPPERupperLeftX, 
                primaryHitbox.UPPERupperLeftY, primaryHitbox.xSize, 
                primaryHitbox.ySize);
        if(lowerHit()||lowerTouch())
        {
            gc.setStroke(Color.RED);
        }
        else
        {
            gc.setStroke(Color.BLUE);
        }
        gc.strokeRect(primaryHitbox.LOWERupperLeftX, 
                primaryHitbox.LOWERupperLeftY, primaryHitbox.xSize, 
                primaryHitbox.ySize);
    }
    
    //=========================================================================
    public void control(Input input)
    {//should be called in the tick method
        if(input.right)
        {
            right();
        }
        else if(input.left)
        {
            left();
        }
        if(input.up)
        {
            up();
        }
        else if(input.down)
        {
            down();
        }
        if(!input.left &&!input.right)
        {
            primaryDeltaBox.frictionX();
        }
        if(!input.up&&!input.down)
        {
            primaryDeltaBox.frictionY();
        }
    }
    
    //========================================================================
    public void right()
    { 
       primaryDeltaBox.increaseX();  
    }
    public void left()
    {
        primaryDeltaBox.decreaseX();
    }
    public void up()
    {
        primaryDeltaBox.decreaseY();
    }
    public void down()
    {
        primaryDeltaBox.increaseY();
    }
    //=========================================================================
    public boolean isHit()
    {//operate delta changes off this method and use the other four below as
        //logical control
        //return primaryHitbox.overlap(collisionBox);
        return primaryDeltaBox.enemyQueue.detectHit(primaryHitbox);
    }
    public boolean leftHit()
    {
        return primaryDeltaBox.enemyQueue.detectLeft(primaryHitbox);
    }
    public boolean rightHit()
    {
        return primaryDeltaBox.enemyQueue.detectRight(primaryHitbox);
    }
    public boolean upperHit()
    {
        return primaryDeltaBox.enemyQueue.detectUpper(primaryHitbox);
    }
    public boolean lowerHit()
    {
        return primaryDeltaBox.enemyQueue.detectLower(primaryHitbox);
    }
    
    //=========================================================================
    
    public boolean isTouch()
    {
        
        return primaryDeltaBox.levelQueue.detectHit(primaryHitbox);
    }
    public boolean leftTouch()
    {
        return primaryDeltaBox.levelQueue.detectLeft(primaryHitbox);
    }
    public boolean rightTouch()
    {
        return primaryDeltaBox.levelQueue.detectRight(primaryHitbox);
    }
    public boolean upperTouch()
    {
        return primaryDeltaBox.levelQueue.detectUpper(primaryHitbox);
    }
    public boolean lowerTouch()
    {
        return primaryDeltaBox.levelQueue.detectLower(primaryHitbox);
    }
    
}
