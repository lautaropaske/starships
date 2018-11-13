package starship.model.solids.powerups;

import processing.core.PConstants;
import starship.base.vector.Vector2;
import starship.model.solids.Solid;
import starship.model.gun.Gun;
import starship.model.gun.GunDecorator;
import starship.model.visitors.PowerUpVisitor;
import starship.model.visitors.Visitor;

import java.awt.*;
import java.util.Random;

public abstract class PowerUp extends Solid {
    GunDecorator decorator;

    PowerUp(String pairID, Vector2 position) {
        this.pairID = pairID;
        this.hp = 1;
        this.position = position;
        this.size = 20;
        this.heading = new Random().nextFloat() * PConstants.TWO_PI;
        this.velocity = Vector2.vector(0,0);
        this.shape = new Rectangle(0,0, this.size, this.size);
        this.visitor = new PowerUpVisitor(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void wentOutOfBounds(int screenX, int screenY) {
        hp -= 2;
    }

    @Override
    public void collisionedWith(Solid collisionable) {
        collisionable.accept(this.visitor);
    }

    public GunDecorator getDecorator() {
        return decorator;
    }

    public abstract void setDecorator(Gun gun);
}
