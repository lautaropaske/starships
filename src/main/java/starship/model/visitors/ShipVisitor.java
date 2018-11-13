package starship.model.visitors;

import starship.model.solids.Asteroid;
import starship.model.solids.powerups.PowerUp;
import starship.model.solids.Ship;
import starship.model.solids.ShotBullet;

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

    @Override
    public void visit(PowerUp powerUp) {
        powerUp.damage(2);
    }
}
