import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sbob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sbob extends Actor
{
    /**
     * Act - do whatever the sbob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int gold;
    public void act()
    {
        if (canCatchGold()) {
            CatchGold();
            gold += 1;
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX()+1,getY());
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX()-1,getY());
        }
        
        hitTrapCheck();
    }
    private boolean canCatchGold() {
        Actor gold = getOneObjectAtOffset(0, 0, pirategold.class);
        if (gold !=  null) {
            return true;
        } else {
            return false;
        }
    }
    private void CatchGold() {
        Actor gold = getOneObjectAtOffset(0, 0, pirategold.class);
        if (gold != null) {
            Greenfoot.playSound("cha_ching.wav");
            getWorld().removeObject(gold);
            ((Waterworld)getWorld()).addScore(1);
        }
    }
    private void hitTrapCheck() {
        if (isTouching(crabtrap.class)) {
            ((Waterworld)getWorld()).endGame();
        }
    }
}
