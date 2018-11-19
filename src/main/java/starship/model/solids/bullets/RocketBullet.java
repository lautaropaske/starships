package starship.model.solids.bullets;

import starship.base.vector.Vector2;

import java.awt.*;

public class RocketBullet extends Bullet {

    public RocketBullet(){
        this.hp = 6;
        this.velocity = Vector2.vector(0,1);
        this.size = 30;
        this.damageCaused = 500;
        this.shape = new Rectangle(0, 0, size, size*2);
    }
}
