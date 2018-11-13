package starship.model;

import processing.core.PConstants;
import starship.base.vector.Vector2;
import starship.model.visitors.AsteroidVisitor;
import starship.model.visitors.Visitor;

import java.awt.*;
import java.util.Random;

public class Asteroid extends Solid{

    public Asteroid(String pairID, int size, Vector2 position){
        this.pairID = pairID;
        this.hp = size;
        this.position = position;
        this.size = size;
        this.heading = new Random().nextFloat() * PConstants.TWO_PI;
        this.velocity = Vector2.vector(0,1);
        this.shape = new Rectangle(0,0, this.size, this.size);
        this.visitor = new AsteroidVisitor(this);
    }

    @Override
    public void collisionedWith(Solid collisionable) {
        collisionable.accept(this.visitor);
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void wentOutOfBounds() {
        hp = -1;
    }

    @Override
    public Vector2 getPosition() {
        this.position = this.position.add(velocity.rotate(heading));
        return position;
    }
}
