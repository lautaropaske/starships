package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;

import static processing.core.PConstants.PI;
import static processing.core.PConstants.TWO_PI;

public class DoubleFire extends GunDecorator{

    public DoubleFire(Gun gun, String pairID, Vector2 position){
        this.gun = gun;
    }

    @Override
    public void fireGun(Player player, Vector2 position, float shipHeading) {
        this.gun.fireGun(player, position, shipHeading);
        this.gun.fireGun(player, position, shipHeading + PI/4);
    }
}
