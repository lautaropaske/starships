package starship.model;

import starship.base.vector.Vector2;

public class Ship extends Solid{



    @Override
    protected void collide(Ship ship) {
        /*Game does not handle ship collisions*/
    }

    @Override
    public void collisionedWith(Solid collisionable) {
        collisionable.collide(this);
    }

    public void addPosition(Vector2 position) {
        this.position.add(position);
        notifyObservers();
    }

    public void rotatePosition(float angle) {
        this.position.rotate(angle);
        notifyObservers();
    }
}
