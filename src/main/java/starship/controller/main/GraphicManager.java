package starship.controller.main;

import processing.core.PGraphics;
import starship.view.SolidG;

import java.util.ArrayList;
import java.util.List;

public class GraphicManager {
    private List<SolidG> graphics;

    public GraphicManager(){
        graphics = new ArrayList<>();
    }

    public void addGraphic(SolidG sg){
        graphics.add(sg);
    }

    public void draw(PGraphics p){
        graphics.forEach(g -> {
            g.drawSelf(p);
        });
    }

}
