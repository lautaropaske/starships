package starship.model.visitors;

import starship.model.Asteroid;
import starship.model.Bullet;
import starship.model.Ship;
import starship.model.ShotBullet;

public class BulletVisitor implements Visitor {

    Bullet bullet;

    public BulletVisitor(Bullet bullet){
        this.bullet = bullet;
    }

    @Override
    public void visit(Ship ship) {

    }

    @Override
    public void visit(Asteroid ship) {

    }

    @Override
    public void visit(ShotBullet bullet) {

    }
}
