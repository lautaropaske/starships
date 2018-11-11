package starship.view;

import processing.core.PConstants;
import processing.core.PGraphics;
import starship.model.Observable;
import starship.model.Solid;

import java.awt.*;

public class ShipG extends SolidG{
    
    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());
        p.rotate(lastState.getHeading());

        p.beginShape();
        p.vertex(0, 0);
        p.vertex(lastState.getSize()*0.5f, lastState.getSize());
        p.vertex(lastState.getSize(), 0);
        p.vertex(lastState.getSize()*0.5f, lastState.getSize()*0.33f);
        p.endShape(PConstants.CLOSE);
        p.popMatrix();
    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update((Solid) observable);
    }
}
