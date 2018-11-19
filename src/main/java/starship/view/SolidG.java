package starship.view;

import processing.core.PGraphics;
import processing.core.PImage;
import starship.model.solids.Observable;
import starship.model.solids.Solid;

public abstract class SolidG implements Observer<Solid>{
    String pairID;
    Solid lastState;
    PImage image;

    @Override
    public void update(Observable<Solid> solid){
        this.lastState = (Solid) solid;
    }
    public abstract void drawSelf(PGraphics p);

    public Solid getLastState() {
        return lastState;
    }
    public String getPairID() {
        return pairID;
    }
}
