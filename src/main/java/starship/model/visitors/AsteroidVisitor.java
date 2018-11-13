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
        ship.damage(asteroid.getSize()/2);
    }

    @Override
    public void visit(Asteroid asteroid) {
        /*Game does not handle asteroids collisions*/
    }

    @Override
    public void visit(ShotBullet bullet) {
        bullet.damage(2);
    }
}
