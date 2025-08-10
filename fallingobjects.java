import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fallingobjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fallingobjects extends Actor
{
    /**
     * Act - do whatever the fallingobjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dropSpeed = 1;
    private boolean onBottom = false;
    public void act() {
        if (((Waterworld)getWorld()).isGameOver()) return;  // ✅ skip everything if game is over
        fall();
        checkBottom();
    }
    public void fall() {
        if (!onBottom) {
            this.setLocation(getX(),getY()+dropSpeed);
            onBottom=checkBottom();
        }
    }
    public boolean checkBottom() {
        if (getY() > 570) {
            return true;
        } else {
            return false;
        }
    }
}
