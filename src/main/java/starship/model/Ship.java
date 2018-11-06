package starship.model;

import starship.base.vector.Vector2;

import java.awt.*;

public class Ship extends Solid{

    public Ship(Vector2 position){
        this.position = position;
        this.size = 30;
        this.heading = 0;
        this.velocity = Vector2.vector(0,5);
        this.shape = new Polygon();
    }


    @Override
    protected void collide(Ship ship) {
        /*Game does not handle ship collisions*/
    }

    @Override
    public void collisionedWith(Solid collisionable) {
        collisionable.collide(this);
    }

    public void addPosition(Vector2 position) {
        this.position = this.position.add(position);
        notifyObservers();
    }

    public void rotatePosition(float angle) {
        this.heading += angle;
        notifyObservers();
    }
}
