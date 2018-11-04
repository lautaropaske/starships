package starship.model.factory;

import starship.controller.main.GraphicManager;
import starship.model.Ship;
import starship.view.ShipG;

public class ShipFactory extends GraphicFactory {
    public ShipFactory(GraphicManager observer) {
        super(observer);
    }

    public Ship createShip() {
        Ship ship = new Ship();
        ShipG shipG = new ShipG();
        ship.add(shipG);
        notifyObserver(shipG);
        return ship;
    }
}
