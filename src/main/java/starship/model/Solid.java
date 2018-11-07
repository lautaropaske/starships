package starship.model;

import starship.base.collision.Collisionable;
import starship.base.vector.Vector2;
import starship.model.visitors.Visitor;

import java.awt.*;

public abstract class Solid extends Observable<Solid> implements Collisionable<Solid> {
    int hp;
    Shape shape;
    Vector2 position;
    Vector2 velocity;
    int size;
    float heading;
    Visitor visitor;

    abstract void accept(Visitor visitor);

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
    public Vector2 getVelocity(){return velocity;}

    public void addPosition(Vector2 position) {
        this.position = this.position.add(position);
        notifyObservers();
    }
    public void rotatePosition(float angle) {
        this.heading += angle;
        notifyObservers();
    }
}
