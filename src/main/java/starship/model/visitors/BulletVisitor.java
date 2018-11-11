package starship.model.visitors;

import starship.model.Asteroid;
import starship.model.Bullet;
import starship.model.Ship;
import starship.model.ShotBullet;

public class BulletVisitor implements Visitor {

    private Bullet bullet;

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
        System.out.println("Asteroid - Bullet hit");
    }
}
