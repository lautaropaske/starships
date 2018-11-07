package starship.model.factories;

import starship.base.vector.Vector2;
import starship.controller.main.GraphicManager;
import starship.model.Player;
import starship.model.Ship;
import starship.view.ShipG;

public class ShipFactory extends GraphicFactory {
    public ShipFactory(GraphicManager observer) {
        super(observer);
    }

    public Ship createShip(Player owner, BulletFactory bf) {
        Ship ship = new Ship(owner, Vector2.vector(400, 300), bf);
        ShipG shipG = new ShipG();
        ship.add(shipG);
        shipG.update(ship);
        notifyObserver(shipG);
        return ship;
    }
}
