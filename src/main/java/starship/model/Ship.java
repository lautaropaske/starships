package starship.model;

import starship.base.vector.Vector2;
import starship.model.factories.BulletFactory;
import starship.model.gun.Gun;
import starship.model.gun.SimpleGun;
import starship.model.visitors.ShipVisitor;
import starship.model.visitors.Visitor;

import java.awt.*;

public class Ship extends Solid{

    private Gun gun;
    private Player owner;

    public Ship(Player owner, Vector2 position, BulletFactory bulletFactory){
        this.hp = 100;
        this.position = position;
        this.size = 30;
        this.heading = 0;
        this.velocity = Vector2.vector(0,5);
        this.shape = new Polygon();
        this.visitor = new ShipVisitor(this);
        this.gun = new SimpleGun(bulletFactory);
        this.owner = owner;
    }

    public void doDamage(int damage){
        this.hp -= damage;
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
}
