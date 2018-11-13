package starship.model.visitors;

import starship.model.solids.Asteroid;
import starship.model.solids.powerups.PowerUp;
import starship.model.solids.Ship;
import starship.model.solids.ShotBullet;

public class PowerUpVisitor implements Visitor {

    private PowerUp powerUp;

    public PowerUpVisitor(PowerUp powerUp){this.powerUp = powerUp;}

    @Override
    public void visit(Ship ship) {
        powerUp.setDecorator(ship.getGun());
        ship.setGun(powerUp.getDecorator());
    }

    @Override
    public void visit(Asteroid asteroid) {
        // None
    }

    @Override
    public void visit(ShotBullet bullet) {
        // None
    }

    @Override
    public void visit(PowerUp powerUp) {
        // None
    }
}
