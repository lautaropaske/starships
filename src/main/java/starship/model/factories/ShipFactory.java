package starship.model.factories;

import processing.core.PImage;
import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.solids.Ship;
import starship.view.ShipG;

import java.util.Map;
import java.util.UUID;

public class ShipFactory extends SolidFactory {

    public ShipFactory(ObjectManager om, Map<String, PImage> images) {
        super(om, images);
    }

    public Ship createShip(Player owner, BulletFactory bf) {
        String pairID = UUID.randomUUID().toString();

        Ship ship = new Ship(pairID, owner, Vector2.vector(om.getScreenX()/2, om.getScreenY()/2), bf);
        ShipG shipG = new ShipG(pairID, this.images.get("ship"));
        ship.add(shipG);
        shipG.update(ship);
        notifyObserver(ship, shipG);
        return ship;
    }
}
