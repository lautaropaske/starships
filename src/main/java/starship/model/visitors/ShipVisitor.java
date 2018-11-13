package starship.model.visitors;

import starship.model.Asteroid;
import starship.model.Ship;
import starship.model.ShotBullet;

public class ShipVisitor implements Visitor {

    private Ship ship;

    public ShipVisitor(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void visit(Ship ship) {
        /*Game does not handle ship collisions*/
    }

    @Override
    public void visit(Asteroid asteroid) {
        /*Ship does not affect asteroids*/
    }

    @Override
    public void visit(ShotBullet shotBullet) {
        /*Do not handle bullet collisions*/
    }
}
