package starship.view;

import processing.core.PGraphics;
import starship.model.Solid;

public abstract class SolidG implements Observer<Solid>{
    Solid lastState;

    @Override
    public void update(Solid solid){
        this.lastState = solid;
    }

    public abstract void drawSelf(PGraphics p);
}
