/*
 * Program:FXgameEngine
 * This:Polygon.java
 * Author:Nicholas Johnston
 * Date:8/10/2016
 * Purpose:This is a class which bundles information for the filly polygon 
           method of the graphical context
           Furthermore it will contain methods which aid in the construction
           of new polygons
 */
package fxgametemplate;

/**
 *
 * @author Nick Johnston
 */
public class Polygon 
{
    //variables
    int verticies = 0;
    int index=0;
    double[] xVerts;
    double[] yVerts;
    double xPos;
    double yPos;
    //constructors
    public Polygon(int verticies, double x, double y)
    {
        this.verticies = verticies;
        xVerts = new double[verticies];
        yVerts = new double[verticies];
        this.xPos = x;
        this.yPos = y;
    }
    //methods
    public void add(int x,int y)
    {
        if(index <= verticies)
        {
            xVerts[index] = x+xPos;
            yVerts[index] = y+yPos;
            index++;
        }
        if(index > verticies)
        {
            index++;
        }
    }
    public double[] getX()
    {
        return xVerts;
    }
    public double[] getY()
    {
        return yVerts;
    }
    
}
