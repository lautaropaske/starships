package starship.model.visitors;

import starship.model.solids.Asteroid;
import starship.model.solids.Ship;
import starship.model.solids.bullets.ShotBullet;

public interface Visitor {
    void visit(Ship ship);
    void visit(Asteroid asteroid);
    void visit(ShotBullet bullet);
}
