package starship.model;

import starship.base.collision.Collisionable;
import starship.base.vector.Vector2;

import java.awt.*;

public abstract class Solid extends Observable<Solid> implements Collisionable<Solid> {
    protected Shape shape;
    protected Vector2 position;

    @Override
    public Shape getShape(){ return shape;}

    public Vector2 getPosition() {
        return position;
    }

    protected abstract void collide(Ship ship);
}
