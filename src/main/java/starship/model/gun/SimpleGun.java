package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;

public class SimpleGun implements Gun{
    private BulletFactory bulletFactory;
    private long lastShot;
    private long cadence;

    public SimpleGun(BulletFactory  bulletFactory){
        this.bulletFactory = bulletFactory;
        this.cadence = 100;
    }

    @Override
    public void fireGun(Player player, Vector2 position, float shipHeading) {
        if((System.currentTimeMillis() - lastShot) >= cadence) {
            bulletFactory.spawnSimpleBullet(player, position, shipHeading);
            lastShot = System.currentTimeMillis();
        }
    }
}
