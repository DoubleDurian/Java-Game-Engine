/*
 * Program:FXGameTemplate
 * This:HitBox.java
 * Author:Nicholas Johnston
 * Date:7/6/2016
 * Purpose:This is a companion object to the DeltaBox, it accepts a delta box
           and calculates the left right upper and lower bounds of the box 
           it also has booleans that return if its hit or not.
 */
package fxgametemplate;

/**
 *
 * @author Nick Johnston
 */
public class HitBox 
{
    //variables
    boolean topHit;
    boolean bottomHit;
    boolean rightHit;
    boolean leftHit;
    
    boolean isSolid;
      
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    
    int xCore;
    int yCore;
    
    //contralhitbox===========================================
    int upperLeftX;
    int upperLeftY;
    
    int lowerRightX;
    int lowerRightY;
    //leftwards hit box=======================================
    int LEFTupperLeftX;
    int LEFTupperLeftY;
    
    int LEFTlowerRightX;
    int LEFTlowerRightY;
    //=========================================================
    //rightwards hitBot
    int RIGHTupperLeftX;
    int RIGHTupperLeftY;
    
    int RIGHTlowerRightX;
    int RIGHTlowerRightY;
    //=========================================================
    //upwards hitbox
    int UPPERupperLeftX;
    int UPPERupperLeftY;
    
    int UPPERlowerRightX;
    int UPPERlowerRightY;
    //=========================================================
    //downwards hitbox
    //=========================================================
    int LOWERupperLeftX;
    int LOWERupperLeftY;
    
    int LOWERlowerRightX;
    int LOWERlowerRightY;
    //constructors
   public HitBox(int xPos, int yPos, int xSize, int ySize)
   {
       //origin and dimensions
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        //central hitbox, determines when the hit occurs
        this.upperLeftX = xPos;
        this.upperLeftY = yPos;
        this.lowerRightX = xPos + xSize;
        this.lowerRightY = yPos + ySize;
        //leftwards hit box
        this.LEFTupperLeftX = xPos - (xSize/2);
        this.LEFTupperLeftY = yPos;
        this.LEFTlowerRightX =xPos + (xSize/2);
        this.LEFTlowerRightY = yPos +ySize;
        //
        //rightwards hitBox
        this.RIGHTupperLeftX =xPos + (xSize/2);
        this.RIGHTupperLeftY = yPos;
        this.RIGHTlowerRightX = xPos + xSize + (xSize/2);
        this.RIGHTlowerRightY = yPos + ySize;        
        //
        //upwards hitbox
        this.UPPERupperLeftX = xPos;
        this.UPPERupperLeftY = yPos -(ySize/2);
        this.UPPERlowerRightX = xPos + xSize;
        this.UPPERlowerRightY = yPos + (ySize/2);      
        //
        //downwards hitbox
        this.LOWERupperLeftX = xPos;
        this.LOWERupperLeftY = yPos + (ySize/2);
        this.LOWERlowerRightX = xPos + xSize;
        this.LOWERlowerRightY = yPos + ySize + (ySize/2);
        //  
   }
    //methods
    public void setLoc(int xPos, int yPos, int xSize, int ySize)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        this.upperLeftX = xPos;
        this.upperLeftY = yPos;
        this.lowerRightX = xPos + xSize;
        this.lowerRightY = yPos + ySize;
        this.LEFTupperLeftX = xPos - (xSize/2);
        this.LEFTupperLeftY = yPos;
        this.LEFTlowerRightX =xPos + (xSize/2);
        this.LEFTlowerRightY = yPos +ySize;
        this.RIGHTupperLeftX =xPos + (xSize/2);
        this.RIGHTupperLeftY = yPos;
        this.RIGHTlowerRightX = xPos + xSize + (xSize/2);
        this.RIGHTlowerRightY = yPos + ySize;
        this.UPPERupperLeftX = xPos;
        this.UPPERupperLeftY = yPos -(ySize/2);
        this.UPPERlowerRightX = xPos + xSize;
        this.UPPERlowerRightY = yPos + (ySize/2);
        this.LOWERupperLeftX = xPos;
        this.LOWERupperLeftY = yPos + (ySize/2);
        this.LOWERlowerRightX = xPos + xSize;
        this.LOWERlowerRightY = yPos + ySize + (ySize/2);
    }
    public void setIsSolid(boolean solid)
    {
        isSolid = solid;
    }
    public boolean getSolid()
    {
        return isSolid;
    }
    public boolean overlap(HitBox hb)
    {
        if(lowerRightY <hb.upperLeftY||upperLeftY> hb.lowerRightY||lowerRightX 
                <hb.upperLeftX||upperLeftX >hb.lowerRightX)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean rightHit(HitBox hb)
    {
        if(RIGHTlowerRightY <hb.LEFTupperLeftY||RIGHTupperLeftY>
                hb.LEFTlowerRightY||RIGHTlowerRightX 
                <hb.LEFTupperLeftX||RIGHTupperLeftX >hb.LEFTlowerRightX)
        {
            return false;
        }
        else
        {
            return overlap(hb);
        }
    }
    public boolean leftHit(HitBox hb)
    {
        if(LEFTlowerRightY <hb.RIGHTupperLeftY||LEFTupperLeftY> 
                hb.RIGHTlowerRightY||LEFTlowerRightX 
                <hb.RIGHTupperLeftX||LEFTupperLeftX >hb.RIGHTlowerRightX)
        {
            return false;
        }
        else
        {
            return overlap(hb);
        }
    }
    public boolean upperHit(HitBox hb)
    {
        if(UPPERlowerRightY <hb.LOWERupperLeftY||UPPERupperLeftY> 
                hb.LOWERlowerRightY||UPPERlowerRightX 
                <hb.LOWERupperLeftX||UPPERupperLeftX >hb.LOWERlowerRightX)
        {
            return false;
        }
        else
        {
            return overlap(hb);
        }
    }
    public boolean lowerHit(HitBox hb)
    {
        if(LOWERlowerRightY <hb.UPPERupperLeftY||LOWERupperLeftY> 
                hb.UPPERlowerRightY||LOWERlowerRightX 
                <hb.UPPERupperLeftX||LOWERupperLeftX >hb.UPPERlowerRightX)
        {
            return false;
        }
        else
        {
            return overlap(hb);
        }
    }
}