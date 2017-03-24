/*
 * Program:FXGameTemplate
 * This:DeltaBox.java
 * Author:Nicholas Johnston
 * Date:7/4/2016
 * Purpose:A Delta Box holds size, location and vector properties of a box in 2D
           space.
             :It contains additional features such as a method for slowing, and
             speeding up
              : Friction blocks to movement to zero are a seperate thing
                increase x and decrease x both add speed but in different  
                  vectors, normalize reduces to zero.

 */
package fxgametemplate;

/**
 *
 * @author Nick Johnston
 */
public class DeltaBox 
{
    //variables
    int xPos;
    int yPos;
    
    int xSize;
    int ySize;
    
    int xVec;
    int yVec;
    
    int xLim;
    int yLim;
    
    CollisionQueue levelQueue = new CollisionQueue();
    CollisionQueue enemyQueue = new CollisionQueue();
    
    
    //int drawX;
    //int drawY;
    //constructor
    public DeltaBox(int xPos,int yPos, int xSize, int ySize,
            int xLim, int yLim)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        
        this.xLim = xLim;
        this.yLim = yLim;
    }
    //methods
    public void addLevel(CollisionQueue level)
    {
        this.levelQueue = level;
    }
    public void addEnemy(CollisionQueue enemy)
    {
        this.enemyQueue = enemy;
    }
    public void setLoc()
    {
        
    }
    public int deltaX(HitBox primaryHitbox,int shift)
    {//build solidity here
        //================================================================
        if(xVec >0 && levelQueue.detectRight(primaryHitbox))
        {
            return xPos;
        }
        else if(xVec<0 &&levelQueue.detectLeft(primaryHitbox))
        {
            return xPos;
        }
        else
        {
            xPos =xPos + xVec;
            return xPos;
        }
        
    }
    public int deltaY(HitBox primaryHitbox,int shift)
    {//build solidity here
        //================================================================
        if(yVec >0 && levelQueue.detectLower(primaryHitbox))
        {//there is an obstacle below and should not move into it
            return yPos;
        }
        else if(yVec <0 &&levelQueue.detectUpper(primaryHitbox))
        {//there is a solid above and should not more into it
            return yPos;
        }
        else
        {//there are no obstacles and the object can move
            yPos = yPos + yVec;
            return yPos;
        } 
    }
    
    public void xReflect()
    {
        xVec *= -1;
    }
    public void yReflect()
    {
        yVec *= -1;
    }
    public void increaseX()
    {
        xVec++;
        if(xVec > xLim)
        {
            xVec = xLim;
        }
    }
    public void decreaseX()
    {
        xVec--;
        if(xVec < (xLim*-1))
        {
            xVec = (xLim*-1);
        }
    }
    public void increaseY()
    {
        yVec++;
        if(yVec > yLim)
        {
            yVec = yLim;
        }
    }   
    public void decreaseY()
    {
        yVec--;
        if(yVec < (yLim*-1))
        {
            yVec = (yLim*-1);
        }
    }
    public void frictionX()
    {
        if(xVec > 0)
        {
            xVec--;
        }
        if(xVec < 0)
        {
            xVec++;
        }
    }
    public void frictionY()
    {
        if(yVec > 0)
        {
            yVec--;
        }
        if(yVec < 0)
        {
            yVec++;
        }
    }
    public void stopX()
    {
        xVec = 0;
    }
    public void stopY()
    {
        yVec = 0;
    }
    //===============================================
    //setter and getters
    //===============================================

    public int getxPos() 
    {
        return xPos;
    }

    public void setxPos(int xPos) 
    {
        this.xPos = xPos;
    }

    public int getyPos() 
    {
        return yPos;
    }

    public void setyPos(int yPos) 
    {
        this.yPos = yPos;
    }

    public int getxSize() 
    {
        return xSize;
    }

    public void setxSize(int xSize) 
    {
        this.xSize = xSize;
    }

    public int getySize() 
    {
        return ySize;
    }

    public void setySize(int ySize) 
    {
        this.ySize = ySize;
    }

    public int getxVec() 
    {
        return xVec;
    }

    public void setxVec(int xVec) 
    {
        this.xVec = xVec;
    }

    public int getyVec() 
    {
        return yVec;
    }

    public void setyVec(int yVec) 
    {
        this.yVec = yVec;
    }
    //=========================================
    //=========================================
}
