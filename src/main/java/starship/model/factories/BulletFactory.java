package starship.model.factories;

import starship.base.collision.CollisionManager;
import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.base.main.GraphicManager;
import starship.model.Bullet;
import starship.model.Player;
import starship.model.ShotBullet;
import starship.model.SimpleBullet;
import starship.view.BulletG;

import java.util.UUID;

public class BulletFactory extends SolidFactory{
    public BulletFactory(ObjectManager om) {
        super(om);
    }

    public void spawnSimpleBullet(Player player, Vector2 position, float shipHeading){
        String pairID = UUID.randomUUID().toString();

        Bullet bullet = new SimpleBullet();
        ShotBullet shot = new ShotBullet(pairID, bullet, player, position, shipHeading);
        BulletG bulletG = new BulletG(pairID);
        shot.add(bulletG);
        bulletG.update(shot);
        notifyObserver(shot, bulletG);
    }
}
