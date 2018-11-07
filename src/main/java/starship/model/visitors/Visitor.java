package starship.model.visitors;

import starship.model.Asteroid;
import starship.model.Ship;
import starship.model.ShotBullet;

public interface Visitor {
    void visit(Ship ship);
    void visit(Asteroid asteroid);
    void visit(ShotBullet bullet);
}
