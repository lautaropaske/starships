package starship.model;

import starship.base.vector.Vector2;
import starship.model.visitors.BulletVisitor;
import starship.model.visitors.Visitor;

import java.awt.*;

public class ShotBullet extends Solid{
    private Bullet bullet;
    private Player player;

    public ShotBullet(String pairID, Bullet bullet, Player player, Vector2 position, float shipHeading) {
        this.hp = bullet.hp;
        this.pairID = pairID;
        this.bullet = bullet;
        this.shape = bullet.shape;
        this.player = player;
        this.position = position;
        this.heading = shipHeading;
        this.visitor = new BulletVisitor(this);
    }

    @Override
    public void collisionedWith(Solid collisionable) { collisionable.accept(this.visitor);}

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void wentOutOfBounds(int screenX, int screenY) {
        hp = -1;
    }

    @Override
    public int getSize(){return bullet.size;}

    /**
     * Position is overriden because Bullet, as Asteroid, moves by itself; that means every time I want to check
     * if Bullet has moved, it moves.
    * */
    @Override
    public Vector2 getPosition(){
        this.position = this.position.add(bullet.velocity.rotate(heading));
        return position;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public Player getPlayer() {
        return player;
    }
}
