package starship.model.factories;

import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.model.solids.Bullet;
import starship.model.Player;
import starship.model.solids.ShotBullet;
import starship.model.solids.SimpleBullet;
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
