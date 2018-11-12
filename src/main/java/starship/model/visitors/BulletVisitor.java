package starship.model.visitors;

import starship.model.Asteroid;
import starship.model.Bullet;
import starship.model.Ship;
import starship.model.ShotBullet;

public class BulletVisitor implements Visitor {

    private ShotBullet bullet;

    public BulletVisitor(ShotBullet bullet){
        this.bullet = bullet;
    }

    @Override
    public void visit(Ship ship) {
        /*Bullets do not damage ship*/
    }

    @Override
    public void visit(Asteroid asteroid) {
        asteroid.damage(bullet.getSize()*1000);
    }

    @Override
    public void visit(ShotBullet bullet) {
        /*Game does not handle bullet collisions*/
    }
}
