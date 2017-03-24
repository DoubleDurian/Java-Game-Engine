/*
 * Program:FXGameTemplate
 * This:CollisionQueue.java
 * Author:Nicholas Johnston
 * Date:7/30/2016
 * Purpose:This iterates through a series of entity boxes to detect if a 
           collision has occured from the standpoint of a prime entity box
 */
package fxgametemplate;

/**
 *
 * @author Nick Johnston
 */
public class CollisionQueue 
{
    //variables
    
    int size = 0;
    int max = 10;
    
    EntityBox[] queue = new  EntityBox[max];
    //constructor
    //methods
    public boolean checkFull()
    {//returns true in the event that the size of the array is maxed out
        //and a further addition would cause a crash
        return size > max;
    }
    public void doubleSize()
    {
        max = max*2;
        EntityBox[] tempArray = new EntityBox[max];
        //now to move hitboxes from queue to temp
        for(int i = 0; i <= size; i ++)
        {
            tempArray[i] = queue[i];
        }
        //now the larger temp array over writes the queue
        queue = tempArray;
    }
    public void enQueue(EntityBox addition)
    {
        if(checkFull())
        {
            doubleSize();
        }
        queue[size] = addition;
        size++;
    }
    public void deQueue(int position)
    {
        queue[position] = null;
    }
    public void dump()
    {
        for(int i = 0; i <=size;i++)
        {
            queue[i] = null;
        }
    }
    public boolean detectLeft(HitBox searched)
    {
        boolean hit = false;
        EntityBox tempBox;
        for(int i = 0; i <= size; i++)
        {
            tempBox = queue[i];
            if(tempBox !=null)
            {
                if(searched.leftHit(tempBox.primaryHitbox))
                {
                    hit = true;
                }
            }
        }
        return hit;
    }
    public boolean detectRight(HitBox searched)
    {
        boolean hit = false;
        EntityBox tempBox;
        for(int i = 0; i <= size; i++)
        {
            tempBox = queue[i];
            if(tempBox !=null)
            {
                if(searched.rightHit(tempBox.primaryHitbox))
                {
                    hit = true;
                }
            }
        }
        return hit;
    }
    public boolean detectUpper(HitBox searched)
    {
        boolean hit = false;
        EntityBox tempBox;
        for(int i = 0; i <= size; i++)
        {
            tempBox = queue[i];
            if(tempBox !=null)
            {
                if(searched.upperHit(tempBox.primaryHitbox))
                {
                    hit = true;
                }
            }
        }
        return hit;
    }
    public boolean detectLower(HitBox searched)
    {
        boolean hit = false;
        EntityBox tempBox;
        for(int i = 0; i <= size; i++)
        {
            tempBox = queue[i];
            if(tempBox !=null)
            {
                if(searched.lowerHit(tempBox.primaryHitbox))
                {
                    hit = true;
                }
            }   
        }
        return hit;
    }
    public boolean detectHit(HitBox searched)
    {
        boolean hit = false;
        EntityBox tempBox;
        for(int i = 0; i <= size; i++)
        {
            
            tempBox = queue[i];
            if(tempBox!=null)
            {
                if(searched.overlap(tempBox.primaryHitbox))
                {
                    hit = true;
                }
            }         
        }
        return hit;
    }
    
    
}
