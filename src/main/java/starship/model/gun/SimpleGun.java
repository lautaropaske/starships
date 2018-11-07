package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;

public class SimpleGun implements Gun{
    private BulletFactory bulletFactory;

    public SimpleGun(BulletFactory  bulletFactory){
        this.bulletFactory = bulletFactory;
    }

    @Override
    public void fireGun(Player player, Vector2 position, float shipHeading) {
        bulletFactory.spawnSimpleBullet(player, position, shipHeading);
    }
}
