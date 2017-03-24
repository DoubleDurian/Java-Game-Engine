/*
 * Program:FXGameTemplate
 * This:AnimatedIamge.java
 * Author:Nicholas Johnston
 * Date:6/10/2016
 * Purpose:To hold a loop of images that creates the illusion of motion
 */
package fxgametemplate;

import javafx.scene.image.Image;

public class AnimatedImage 
{
    //variables
    public Image[] frames;
    public double duration;
    int xPos;
    int yPos;
    //constructor
    public AnimatedImage(int numberOfFrames, String fileName ,double length)
    {
        this.duration = length;
        frames = new Image[numberOfFrames];
        for(int i = 0; i <numberOfFrames;i++)
        {
            int position = i+1;
            String tempName ="/res/"+fileName+"/"+fileName+ position+".png";
            frames[i] = new Image (tempName);
        }
    }
    //methods
    public Image getFrame(double time)
    {
        int index = (int)((time % (frames.length * duration)) / duration);
        return frames[index];
    }
    
}
