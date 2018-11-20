package starship.view;

import processing.core.PGraphics;

/**
 * Represents borders in the screen
 */
public class Border implements Drawable{
    private int screenX;
    private int screenY;

    public Border(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
    }


    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();

        p.fill(0);
        p.rect(0, 0, screenX, (screenX/20f)); // Top
        p.rect(screenX-(screenX/20f), 0, (screenX/20f), screenY); // Right
        p.rect(0, screenY-(screenX/20f), screenX, (screenX/20f)); // Bottom
        p.rect(0, 0, (screenX/20f), screenY); // Left
        p.noFill();
        p.popMatrix();
    }
}
