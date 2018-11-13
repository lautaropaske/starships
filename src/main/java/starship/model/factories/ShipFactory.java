package starship.model.factories;

import starship.base.collision.CollisionManager;
import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.base.main.GraphicManager;
import starship.model.Player;
import starship.model.Ship;
import starship.view.ShipG;

import java.util.UUID;

public class ShipFactory extends SolidFactory {
    public ShipFactory(ObjectManager om) {
        super(om);
    }

    public Ship createShip(Player owner, BulletFactory bf) {
        String pairID = UUID.randomUUID().toString();

        Ship ship = new Ship(pairID, owner, Vector2.vector(om.getScreenX()/2, om.getScreenY()/2), bf);
        ShipG shipG = new ShipG(pairID);
        ship.add(shipG);
        shipG.update(ship);
        notifyObserver(ship, shipG);
        return ship;
    }
}
