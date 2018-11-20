package starship.model.solids;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;
import starship.model.gun.Gun;
import starship.model.gun.RocketGun;
import starship.model.gun.SimpleGun;
import starship.model.visitors.ShipVisitor;
import starship.model.visitors.Visitor;

import java.awt.*;
import java.util.*;

public class Ship extends Solid{

    private int lives;
    private Queue<Gun> guns;
    private Player owner;

    public Ship(String pairID, Player owner, Vector2 position, BulletFactory bulletFactory){
        this.pairID = pairID;
        this.hp = 1000;
        this.position = position;
        this.size = 80;
        this.damageCaused = 30;
        this.heading = 0;
        this.velocity = Vector2.vector(0,5);
        this.shape = new Rectangle(0,0, size, size);
        this.visitor = new ShipVisitor(this);
        this.guns = new LinkedList<>();
        guns.add(new SimpleGun(bulletFactory));
        guns.add(new RocketGun(bulletFactory));
        this.owner = owner;
        this.lives = owner.getLives();
    }

    public void fireGun(){
        if(hp > 0) this.guns.peek().fireGun(owner, position, this.heading);
    }

    public void changeGun(){
        guns.add(guns.remove());
    }

    @Override
    public void collisionedWith(Solid collisionable) {
        if(hp > 0) collisionable.accept(this.visitor);
    }

    @Override
    public void accept(Visitor visitor) {
        if(hp > 0) visitor.visit(this);
    }

    @Override
    public void wentOutOfBounds(int screenX, int screenY) {
        if(position.getX() > screenX) position = Vector2.vector(0, position.getY());
        if(position.getY() > screenY) position = Vector2.vector(position.getX(), 0);

        if(position.getX() < 0) position = Vector2.vector(screenX, position.getY());
        if(position.getY() < 0) position = Vector2.vector(position.getX(), screenY);

    }

    @Override
    public void damage(int amount){
        hp -= amount;

        if(hp <= 0 && lives > 1){
            hp = 1000;
            lives--;
        }
    }

    public Player getOwner() {
        return owner;
    }
}
