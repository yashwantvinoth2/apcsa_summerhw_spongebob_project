import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class waterworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waterworld extends World
{
    private int score = 0;
    private boolean gameOver = false;
    public Waterworld()
    {
        super(800, 600, 1);
        prepare();
    }
    public void dropGold(){
        pirategold g = new pirategold();
        addObject(g,Greenfoot.getRandomNumber(getWidth()),10);
    }

    public void dropTrap(){
        crabtrap t = new crabtrap();
        addObject(t,50+Greenfoot.getRandomNumber(getWidth()-100),10);
    }

    public void act(){
        if (gameOver) return;
        if (Greenfoot.getRandomNumber(120)==5){
            dropGold();
        }
        if (Greenfoot.getRandomNumber(720)==20){
            dropTrap();
        }
    }
    private void prepare()
    {
        sbob spongebob = new sbob();
        addObject(spongebob, 328, 537);
        spongebob.setLocation(399, 527);
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public void addScore(int change) {
        if (gameOver) return;
        score += change;
        showScore();
    }
    private void showScore() {
        showText("Score: " + score, 70, 20);
    }
    private void showCollectedCoins() {
        int centerX = getWidth() / 2;
        int baseY = getHeight() / 2 + 60;  // Y-position below text
        int spacing = 40;                 // space between coins
        int startX = centerX - ((score - 1) * spacing / 2);  // center the row
    
        for (int i = 0; i < score; i++) {
            Actor coin = new Actor() {};
            addObject(new pirategold(), startX + i * spacing, baseY);
        }
    }
    public void endGame() {
        gameOver = true;
        showText("game over".toUpperCase(), getWidth()/2, getHeight()/2);
        showText("Score: " + score, getWidth()/2, getHeight()/2 + 30);
        removeObjects(getObjects(pirategold.class));
        removeObjects(getObjects(crabtrap.class));
        showCollectedCoins();
    }
}