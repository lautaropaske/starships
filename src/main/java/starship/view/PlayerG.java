package starship.view;

import processing.core.PGraphics;
import starship.model.Player;
import starship.model.solids.Observable;

public class PlayerG  implements Observer<Player>, Drawable{
    private String pairID;
    private Player lastState;
    private int drawX;
    private int drawY;
    private int size;

    public PlayerG(int drawX, int drawY, int size){
        this.drawX = drawX;
        this.drawY = drawY;
        this.size = size;
    }

    @Override
    public void drawSelf(PGraphics p){
        p.pushMatrix();
        p.translate((float) drawX, (float) drawY);

        p.fill(255);
        p.rect(10,0,size-10f,100);
        String player = ""+lastState.getName();
        String score = "Score: "+lastState.getScore()+"  Lives: "+lastState.getLives();
        p.fill(0);
        p.textSize(24);
        p.text(player, 50, 50);
        p.textSize(16);
        p.text(score, 50, 75);
        p.noFill();

        p.popMatrix();
    }

    public Player getLastState() {
        return lastState;
    }

    public String getPairID() {
        return pairID;
    }

    @Override
    public void update(Observable<Player> observable) {
        this.lastState = (Player) observable;
    }
}
