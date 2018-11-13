package starship.model.solids;

import starship.base.collision.Collisionable;
import starship.base.vector.Vector2;
import starship.model.visitors.Visitor;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Solid extends Observable<Solid> implements Collisionable<Solid> {
    protected String pairID;
    protected int hp;
    protected Shape shape;
    protected Vector2 position;
    protected Vector2 velocity;
    protected int size;
    protected float heading;
    protected Visitor visitor;
    protected int damageCaused;

    public abstract void accept(Visitor visitor);
    public abstract void wentOutOfBounds(int screenX, int screenY);

    @Override
    public Shape getShape(){ return AffineTransform.getTranslateInstance(position.getX(), position.getY()).createTransformedShape(shape);}
    public String getPairID() {
        return pairID;
    }

    public int getDamageCaused(){
        return damageCaused;
    };

    public Vector2 getPosition() {
        return position;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
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

    public void damage(int amount){
        hp -= amount;
    }
}
