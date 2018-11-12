package starship.base.main;

import processing.core.PGraphics;
import starship.view.SolidG;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphicManager {
    private List<SolidG> graphics;

    public GraphicManager(){
        graphics = new ArrayList<>();
    }

    public void addGraphic(SolidG sg){
        graphics.add(sg);
    }
    public void draw(PGraphics p){
//        graphics.removeAll(graphics.stream().filter(e -> e.getLastState().getHp() <= 0).collect(Collectors.toList()));
//        graphics.forEach( e -> {
//
//        });
        graphics.forEach(g -> g.drawSelf(p));
    }
}
