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
        this.image.resize(lastState.getSize(),lastState.getSize());

        p.pushMatrix();
        p.shapeMode(PConstants.CENTER);
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
