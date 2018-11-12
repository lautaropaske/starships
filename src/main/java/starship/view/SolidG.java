package starship.view;

import processing.core.PGraphics;
import starship.base.vector.Vector2;
import starship.model.Solid;

public abstract class SolidG implements Observer<Solid>{
    String pairID;
    Solid lastState;
    boolean clean;

    @Override
    public void update(Solid solid){
        this.lastState = solid;
    }
    public abstract void drawSelf(PGraphics p);

    public Solid getLastState() {
        return lastState;
    }
    public String getPairID() {
        return pairID;
    }
}
