package starship.view;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public class SimpleBulletG extends SolidG{

    public SimpleBulletG(String pairID, PImage image){
        this.pairID = pairID;
        this.image = image;
    }

    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();
        p.shapeMode(PConstants.CENTER);
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());
        p.rotate(lastState.getHeading());

        p.fill(255);
        p.ellipse(0,0,lastState.getSize(), lastState.getSize());
        p.popMatrix();
    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update(observable);
    }
}
