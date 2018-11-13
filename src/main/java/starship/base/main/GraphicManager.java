package starship.base.main;

import processing.core.PGraphics;
import starship.view.Drawable;
import starship.view.SolidG;

import java.util.ArrayList;
import java.util.List;

public class GraphicManager {
    private List<SolidG> solidGS;
    private List<Drawable> drawables;
    private int screenX;
    private int screenY;

    public GraphicManager(){
        solidGS = new ArrayList<>();
        drawables = new ArrayList<>();
    }

    void addSolidG(SolidG solidG){
        solidGS.add(solidG);
    }
    
    void addDrawable(Drawable drawable){
        drawables.add(drawable);
    }

    void draw(PGraphics p){
        solidGS.forEach(g -> g.drawSelf(p));
        drawables.forEach(d -> d.drawSelf(p));
    }

    void clean() {
        List<SolidG> remove = new ArrayList<>();
        solidGS.forEach(e -> {
            if(ObjectManager.isOutOfBounds(e.getLastState().getPosition(), screenX, screenY)) e.getLastState().wentOutOfBounds(screenX, screenY);
            if(e.getLastState().getHp() <= 0) remove.add(e);
        });
        solidGS.removeAll(remove);
    }

    void setScreenX(int screenX) {
        this.screenX = screenX;
    }
    void setScreenY(int screenY) {
        this.screenY = screenY;
    }
}
