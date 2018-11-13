package starship.base.main;

import processing.core.PGraphics;
import starship.view.SolidG;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphicManager {
    private List<SolidG> graphics;
    private int screenX;
    private int screenY;

    public GraphicManager(){
        graphics = new ArrayList<>();
    }

    void addGraphic(SolidG sg){
        graphics.add(sg);
    }

    void draw(PGraphics p){
        graphics.forEach(g -> g.drawSelf(p));
    }
    void clean() {
        graphics.forEach(e -> {
            if(ObjectManager.isOutOfBounds(e.getLastState().getPosition(), screenX, screenY)) e.getLastState().wentOutOfBounds();
        });
        graphics.removeAll(graphics.stream().filter(e -> e.getLastState().getHp() <= 0).collect(Collectors.toList()));
    }

    void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    void setScreenY(int screenY) {
        this.screenY = screenY;
    }
}
