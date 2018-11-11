package starship.controller;

import starship.base.vector.Vector2;
import starship.model.Ship;

public class ShipController {
    private Ship ship;

    public ShipController(Ship ship){
        this.ship = ship;
    }

    public void fireGun() {
        ship.fireGun();
    }

    public void moveDown() {
        ship.addPosition(ship.getVelocity().multiply(-1f).rotate(ship.getHeading()));
    }

    public void moveUp() {
        ship.addPosition(ship.getVelocity().rotate(ship.getHeading()));
    }

    public void moveLeft() {
        ship.rotatePosition(-0.1f);
    }

    public void moveRight() {
        ship.rotatePosition(0.1f);
    }
}
