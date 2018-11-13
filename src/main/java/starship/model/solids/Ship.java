package starship.model.solids;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;
import starship.model.gun.Gun;
import starship.model.gun.SimpleGun;
import starship.model.visitors.ShipVisitor;
import starship.model.visitors.Visitor;

import java.awt.*;

public class Ship extends Solid{

    private Gun gun;
    private Player owner;

    public Ship(String pairID, Player owner, Vector2 position, BulletFactory bulletFactory){
        this.pairID = pairID;
        this.hp = 1000000000;
        this.position = position;
        this.size = 30;
        this.heading = 0;
        this.velocity = Vector2.vector(0,5);
        this.shape = new Rectangle(0,0, size, size);
        this.visitor = new ShipVisitor(this);
        this.gun = new SimpleGun(bulletFactory);
        this.owner = owner;
    }

    public void fireGun(){
        this.gun.fireGun(owner, position, this.heading);
    }

    @Override
    public void collisionedWith(Solid collisionable) {
        collisionable.accept(this.visitor);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void wentOutOfBounds(int screenX, int screenY) {
        if(position.getX() > screenX) position = Vector2.vector(0, position.getY());
        if(position.getY() > screenY) position = Vector2.vector(position.getX(), 0);

        if(position.getX() < 0) position = Vector2.vector(screenX, position.getY());
        if(position.getY() < 0) position = Vector2.vector(position.getX(), screenY);

    }

    public void setGun(Gun gun){
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }
}
