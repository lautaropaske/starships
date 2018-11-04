package starship.controller.model;

import starship.base.vector.Vector2;
import starship.model.Ship;

public class ShipController {
    private Ship ship;

    public ShipController(Ship ship){
        this.ship = ship;
    }

    public void fireGun() {
        /**/
    }

    public void moveDown() {
        ship.addPosition(Vector2.vector(0,-10));
    }

    public void moveUp() {
        ship.addPosition(Vector2.vector(0,10));
        /**/
    }

    public void moveLeft() {
        ship.rotatePosition(0.5f);
        /**/
    }

    public void moveRight() {
        ship.rotatePosition(-0.5f);
        /**/
    }
}
