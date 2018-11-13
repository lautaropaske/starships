package starship.view;

import processing.core.PGraphics;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public class BulletG extends SolidG{

    public BulletG(String pairID){
        this.pairID = pairID;
    }

    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();
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
