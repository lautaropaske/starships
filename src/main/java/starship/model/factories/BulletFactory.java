package starship.model.factories;

import processing.core.PImage;
import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.model.solids.bullets.Bullet;
import starship.model.Player;
import starship.model.solids.bullets.RocketBullet;
import starship.model.solids.bullets.ShotBullet;
import starship.model.solids.bullets.SimpleBullet;
import starship.view.RocketBulletG;
import starship.view.SimpleBulletG;

import java.util.Map;
import java.util.UUID;

public class BulletFactory extends SolidFactory{
    public BulletFactory(ObjectManager om, Map<String, PImage> images) {
        super(om, images);
    }

    public void spawnSimpleBullet(Player player, Vector2 position, float shipHeading){
        String pairID = UUID.randomUUID().toString();

        Bullet bullet = new SimpleBullet();
        ShotBullet shot = new ShotBullet(pairID, bullet, player, position, shipHeading);
        SimpleBulletG bulletG = new SimpleBulletG(pairID, this.images.get("simpleBullet"));
        shot.add(bulletG);
        bulletG.update(shot);
        notifyObserver(shot, bulletG);
    }

    public void spawnRocketBullet(Player player, Vector2 position, float shipHeading){
        String pairID = UUID.randomUUID().toString();

        Bullet bullet = new RocketBullet();
        ShotBullet shot = new ShotBullet(pairID, bullet, player, position, shipHeading);
        RocketBulletG bulletG = new RocketBulletG(pairID, this.images.get("rocketBullet"));
        shot.add(bulletG);
        bulletG.update(shot);
        notifyObserver(shot, bulletG);
    }
}
