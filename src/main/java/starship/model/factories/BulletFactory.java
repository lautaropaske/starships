package starship.model.factories;

import starship.base.vector.Vector2;
import starship.controller.main.GraphicManager;
import starship.model.Bullet;
import starship.model.Player;
import starship.model.ShotBullet;
import starship.model.SimpleBullet;
import starship.view.BulletG;

public class BulletFactory extends GraphicFactory{
    public BulletFactory(GraphicManager observer) {
        super(observer);
    }

    public void spawnSimpleBullet(Player player, Vector2 position){
        Bullet bullet = new SimpleBullet();
        ShotBullet shot = new ShotBullet(bullet, player, position);
        BulletG bulletG = new BulletG();
        shot.add(bulletG);
        bulletG.update(shot);
        notifyObserver(bulletG);
    }
}
