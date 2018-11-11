package starship.view;

import processing.core.PGraphics;
import starship.model.Observable;
import starship.model.Solid;

import java.awt.*;

public class BulletG extends SolidG{

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
