package starship.view;

import processing.core.PGraphics;
import starship.model.Observable;
import starship.model.Solid;

public class ShipG extends SolidG{
    int r = 10;

    @Override
    public void drawSelf(PGraphics p) {
        p.rect(r,r,r,r);
    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update((Solid) observable);
    }
}
