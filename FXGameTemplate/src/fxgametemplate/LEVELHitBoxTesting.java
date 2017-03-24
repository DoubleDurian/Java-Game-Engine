/*
 * Program:FXGameTemplate
 * This:LEVELHitBoxTesting.java
 * Author:Nicholas Johnston
 * Date:7/11/2016
 * Purpose:To test the effectivness of different hitboxes and to develope a 
   method of continuous motion.
 */
package fxgametemplate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class LEVELHitBoxTesting implements Level
{
    //variables
    CollisionQueue enemyQueue = new CollisionQueue();
    CollisionQueue levelQueue = new CollisionQueue();
    
    EntityBox player = new EntityBox(150,200,50,50,10,10);
    EntityBox obstacle1 = new EntityBox(300,300,50,50,0,0);
    EntityBox obstacle2 = new EntityBox(800,300,50,50,0,0);
             
    
    //constructors
    public LEVELHitBoxTesting()
    {
        init();
    }
    //methods
    public void init()
    {
        levelQueue.enQueue(obstacle1);
        levelQueue.enQueue(obstacle2);
        player.setEnemy(enemyQueue);
        player.setLevel(levelQueue);
    }

    @Override
    public void render(GraphicsContext gc, double time) 
    {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1370, 768);
        player.debugRender(gc, time);
        obstacle1.debugRender(gc, time);
        obstacle2.debugRender(gc, time);
        
    }

    @Override
    public void tick(Input input) 
    {
        player.updatePos();
        player.control(input);
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
