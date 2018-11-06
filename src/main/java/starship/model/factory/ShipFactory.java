package starship.model.factory;

import starship.base.vector.Vector2;
import starship.controller.main.GraphicManager;
import starship.model.Ship;
import starship.view.ShipG;

public class ShipFactory extends GraphicFactory {
    public ShipFactory(GraphicManager observer) {
        super(observer);
    }

    public Ship createShip() {
        Ship ship = new Ship(Vector2.vector(400, 300));
        ShipG shipG = new ShipG();
        ship.add(shipG);
        shipG.update(ship);
        notifyObserver(shipG);
        return ship;
    }
}
