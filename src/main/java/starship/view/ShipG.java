package starship.view;

import processing.core.PConstants;
import processing.core.PGraphics;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public class ShipG extends SolidG{

    public ShipG(String pairID){
        this.pairID = pairID;
    }
    
    @Override
    public void drawSelf(PGraphics p) {
        p.pushMatrix();
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());

        p.fill(51, 153, 255);
        p.rect(-lastState.getSize(),-lastState.getSize()*1.6f,lastState.getHp()/(float)20,10);
        p.noFill();

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
