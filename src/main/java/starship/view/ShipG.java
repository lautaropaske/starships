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
        //TODO BULLETS ARE SHOWING OVER SHIP
        p.pushMatrix();
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());
        p.rotate(lastState.getHeading());

        p.fill(255);
        p.beginShape();
        p.vertex(-lastState.getSize()*0.5f, -lastState.getSize()*0.5f);
        p.vertex(0,lastState.getSize()*0.5f);
        p.vertex(lastState.getSize()*0.5f, -lastState.getSize()*0.5f);
        p.vertex(0, -lastState.getSize()*0.33f);
        p.endShape(PConstants.CLOSE);
        p.noFill();

        p.fill(51, 153, 255);
        p.rect(-lastState.getSize(),-lastState.getSize()*1.5f,lastState.getHp()/(float)20,5);
        p.noFill();
        p.popMatrix();

    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update((Solid) observable);
    }
}
