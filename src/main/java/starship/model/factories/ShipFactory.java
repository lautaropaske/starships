package starship.model.factories;

import starship.base.collision.CollisionManager;
import starship.base.vector.Vector2;
import starship.base.main.GraphicManager;
import starship.model.Player;
import starship.model.Ship;
import starship.view.ShipG;

import java.util.UUID;

public class ShipFactory extends SolidFactory {
    public ShipFactory(GraphicManager observer, CollisionManager observer2) {
        super(observer, observer2);
    }

    public Ship createShip(Player owner, BulletFactory bf) {
        String pairID = UUID.randomUUID().toString();

        Ship ship = new Ship(pairID, owner, Vector2.vector(400, 300), bf);
        ShipG shipG = new ShipG(pairID);
        ship.add(shipG);
        shipG.update(ship);
        notifyObserver(shipG);
        return ship;
    }
}
