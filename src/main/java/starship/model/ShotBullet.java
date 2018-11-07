package starship.model;

import starship.base.vector.Vector2;
import starship.model.visitors.BulletVisitor;
import starship.model.visitors.Visitor;

public class ShotBullet extends Solid{
    Bullet bullet;
    Player player;

    public ShotBullet(Bullet bullet, Player player, Vector2 position) {
        this.bullet = bullet;
        this.player = player;
        this.position = position;
        this.visitor = new BulletVisitor(bullet);
    }

    @Override
    public void collisionedWith(Solid collisionable) { collisionable.accept(this.visitor);}

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
