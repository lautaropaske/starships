package starship.controller;

import starship.base.vector.Vector2;
import starship.model.solids.Ship;

public class ShipController {
    private Ship ship;

    public ShipController(Ship ship){
        this.ship = ship;
    }

    public void fireGun() {
        ship.fireGun();
    }

    public void moveDown() {
        Vector2 position = ship.getVelocity().multiply(-1f).rotate(ship.getHeading());
        ship.addPosition(position);
    }

    public void moveUp() {
        Vector2 position = ship.getVelocity().rotate(ship.getHeading());
        ship.addPosition(position);
    }

    public void moveLeft() {
        ship.rotatePosition(-0.1f);
    }

    public void moveRight() {
        ship.rotatePosition(0.1f);
    }
}
