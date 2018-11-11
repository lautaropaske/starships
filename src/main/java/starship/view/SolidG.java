package starship.view;

import processing.core.PGraphics;
import starship.model.Solid;

import java.awt.*;

public abstract class SolidG implements Observer<Solid>{
    Solid lastState;

    @Override
    public void update(Solid solid){
        this.lastState = solid;
    }

    public abstract void drawSelf(PGraphics p);

    public Solid getLastState() {
        return lastState;
    }
}
