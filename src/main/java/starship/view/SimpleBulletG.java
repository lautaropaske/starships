package starship.view;

import processing.core.PConstants;
import processing.core.PGraphics;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public class SimpleBulletG extends SolidG{

    public SimpleBulletG(String pairID){
        this.pairID = pairID;
    }

    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();
        p.shapeMode(PConstants.CENTER);
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());
        p.rotate(lastState.getHeading());

        p.rect(0,0, lastState.getSize(), lastState.getSize());
        p.popMatrix();
    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update((Solid) observable);
    }
}
