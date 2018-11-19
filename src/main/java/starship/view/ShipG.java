package starship.view;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public class ShipG extends SolidG{

    public ShipG(String pairID, PImage image){
        this.pairID = pairID;
        this.image = image;
    }
    
    @Override
    public void drawSelf(PGraphics p) {
        //TODO BULLETS ARE SHOWING OVER SHIP
        p.pushMatrix();
        p.translate(lastState.getPosition().getX(), lastState.getPosition().getY());
        p.rotate(lastState.getHeading());

        p.image(image,-lastState.getSize()*0.5f,-lastState.getSize()*0.5f,lastState.getSize(),lastState.getSize());

        p.fill(51, 153, 255);
        p.rect(-lastState.getSize()*0.5f + 15,-lastState.getSize()*0.5f - 10,lastState.getHp()/(float)20,5);
        p.noFill();
        p.popMatrix();

    }

    @Override
    public void update(Observable<Solid> observable) {
        super.update((Solid) observable);
    }
}
