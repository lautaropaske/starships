package starship.base.collision;

import starship.model.Solid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollisionManager {
    private List<Solid> collisionables;
    private CollisionEngine<Solid> engine;

    public CollisionManager(){
        collisionables = new ArrayList<>();
        engine = new CollisionEngine<>();
    }

    public void addCollisionable(Solid s){
        collisionables.add(s);
    }
    public void collide(){
//        collisionables.removeAll(collisionables.stream().filter(e -> e.getHp() <= 0).collect(Collectors.toList()));
        engine.checkCollisions(collisionables);
    }
}
