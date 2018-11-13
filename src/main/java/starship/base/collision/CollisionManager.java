package starship.base.collision;

import starship.base.main.ObjectManager;
import starship.model.Solid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollisionManager {
    private List<Solid> collisionables;
    private CollisionEngine<Solid> engine;
    private int screenX;
    private int screenY;

    public CollisionManager(){
        collisionables = new ArrayList<>();
        engine = new CollisionEngine<>();
    }

    public void addCollisionable(Solid s){
        collisionables.add(s);
    }

    public void clean(){
        collisionables.forEach(e -> {
            if(ObjectManager.isOutOfBounds(e.getPosition(), screenX, screenY)) e.wentOutOfBounds();
        });
        collisionables.removeAll(collisionables.stream().filter(e -> e.getHp() <= 0).collect(Collectors.toList()));
    }

    public void collide(){
        engine.checkCollisions(collisionables);
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }
}
