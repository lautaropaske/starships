package starship.model.visitors;

import starship.model.solids.Asteroid;
import starship.model.solids.Ship;
import starship.model.solids.bullets.ShotBullet;

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
        asteroid.damage(ship.getDamageCaused());
    }

    @Override
    public void visit(ShotBullet shotBullet) {
        if(!shotBullet.getPlayer().equals(ship.getOwner())) shotBullet.damage(ship.getDamageCaused());
    }
}
