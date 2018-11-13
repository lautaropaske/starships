package starship.model.visitors;

import starship.model.solids.Asteroid;
import starship.model.solids.Ship;
import starship.model.solids.bullets.ShotBullet;

public class BulletVisitor implements Visitor {

    private ShotBullet bullet;

    public BulletVisitor(ShotBullet bullet){
        this.bullet = bullet;
    }

    @Override
    public void visit(Ship ship) {
        if(!bullet.getPlayer().equals(ship.getOwner())) {
            ship.damage(bullet.getDamageCaused());
            if(ship.getHp() <= 0) bullet.getPlayer().scored(1000);
        }
    }

    @Override
    public void visit(Asteroid asteroid) {
        asteroid.damage(bullet.getSize()*1000);
        if(asteroid.getHp() <= 0) bullet.getPlayer().scored(asteroid.getSize());
    }

    @Override
    public void visit(ShotBullet bullet) {
        /*Game does not handle bullet collisions*/
    }
}
