package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;

public class RocketGun implements Gun {
    private BulletFactory bulletFactory;
    private long lastShot;
    private long cadence;

    public RocketGun(BulletFactory bulletFactory){
        this.bulletFactory = bulletFactory;
        this.cadence = 500;
    }

    @Override
    public void fireGun(Player player, Vector2 position, float shipHeading) {
        if((System.currentTimeMillis() - lastShot) >= cadence) {
            bulletFactory.spawnRocketBullet(player,position,shipHeading);
            lastShot = System.currentTimeMillis();
        }
    }
}
