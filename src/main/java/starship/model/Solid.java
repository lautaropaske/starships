package starship.model;

import starship.base.collision.Collisionable;
import starship.base.vector.Vector2;

import java.awt.*;

public abstract class Solid extends Observable<Solid> implements Collisionable<Solid> {
    Shape shape;
    Vector2 position;
    Vector2 velocity;
    int size;
    float heading;


    @Override
    public Shape getShape(){ return shape;}

    public Vector2 getPosition() {
        return position;
    }

    public int getSize() {
        return size;
    }

    public float getHeading() {
        return heading;
    }

    protected abstract void collide(Ship ship);

    public Vector2 getVelocity(){return velocity;}
}
