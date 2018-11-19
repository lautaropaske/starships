package starship.view;

import processing.core.PGraphics;
import processing.core.PImage;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public class RocketBulletG extends SolidG{
    public RocketBulletG(String pairID, PImage image) {
        this.pairID = pairID;
        this.image = image;
    }

    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());
        p.rotate(lastState.getHeading());

        p.image(image,0,0, lastState.getSize(), lastState.getSize());
        p.popMatrix();
    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update((Solid) observable);
    }
}
