package starship.model.visitors;

import starship.model.solids.Asteroid;
import starship.model.solids.Ship;
import starship.model.solids.bullets.ShotBullet;

public class AsteroidVisitor implements Visitor {

    private Asteroid asteroid;

    public AsteroidVisitor(Asteroid asteroid){
        this.asteroid = asteroid;
    }

    @Override
    public void visit(Ship ship) {
        ship.damage(asteroid.getDamageCaused());
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
