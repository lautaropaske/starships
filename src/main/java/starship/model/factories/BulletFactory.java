package starship.model.factories;

import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.model.solids.bullets.Bullet;
import starship.model.Player;
import starship.model.solids.bullets.RocketBullet;
import starship.model.solids.bullets.ShotBullet;
import starship.model.solids.bullets.SimpleBullet;
import starship.view.RocketBulletG;
import starship.view.SimpleBulletG;

import java.util.UUID;

public class BulletFactory extends SolidFactory{
    public BulletFactory(ObjectManager om) {
        super(om);
    }

    public void spawnSimpleBullet(Player player, Vector2 position, float shipHeading){
        String pairID = UUID.randomUUID().toString();

        Bullet bullet = new SimpleBullet();
        ShotBullet shot = new ShotBullet(pairID, bullet, player, position, shipHeading);
        SimpleBulletG bulletG = new SimpleBulletG(pairID);
        shot.add(bulletG);
        bulletG.update(shot);
        notifyObserver(shot, bulletG);
    }

    public void spawnRocketBullet(Player player, Vector2 position, float shipHeading){
        String pairID = UUID.randomUUID().toString();

        Bullet bullet = new RocketBullet();
        ShotBullet shot = new ShotBullet(pairID, bullet, player, position, shipHeading);
        RocketBulletG bulletG = new RocketBulletG(pairID);
        shot.add(bulletG);
        bulletG.update(shot);
        notifyObserver(shot, bulletG);
    }
}
