package starship.view;

import processing.core.PGraphics;
import starship.model.solids.Solid;

public abstract class SolidG implements Observer<Solid>{
    String pairID;
    Solid lastState;

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
