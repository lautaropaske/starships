package starship.base.collision;

import processing.core.PGraphics;
import starship.base.collision.CollisionEngine;
import starship.model.Solid;
import starship.view.SolidG;

import java.util.ArrayList;
import java.util.List;

public class GraphicManager {
    private List<SolidG> graphics;
    private List<Solid> collisionables;
    private CollisionEngine<Solid> engine;

    public GraphicManager(){
        graphics = new ArrayList<>();
        collisionables = new ArrayList<>();
        engine = new CollisionEngine<>();
    }

    public void addGraphic(SolidG sg){
        graphics.add(sg);
    }

    public void addCollisionable(Solid s){
        collisionables.add(s);
    }

    public void draw(PGraphics p){
        engine.checkCollisions(collisionables);
        graphics.forEach(g -> g.drawSelf(p));
    }

}
