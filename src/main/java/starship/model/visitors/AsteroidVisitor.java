package starship.model.visitors;

import starship.model.Asteroid;
import starship.model.Ship;
import starship.model.ShotBullet;

public class AsteroidVisitor implements Visitor {

    private Asteroid asteroid;

    public AsteroidVisitor(Asteroid asteroid){
        this.asteroid = asteroid;
    }

    @Override
    public void visit(Ship ship) {
        ship.doDamage(asteroid.getSize()/2);
    }

    @Override
    public void visit(Asteroid asteroid) {

    }

    @Override
    public void visit(ShotBullet bullet) {

    }
}
