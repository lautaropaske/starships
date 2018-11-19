package starship.model.solids.bullets;

import starship.base.vector.Vector2;
import java.awt.*;

public class SimpleBullet extends Bullet{

    public SimpleBullet(){
        this.hp = 1;
        this.velocity = Vector2.vector(0,5);
        this.size = 10;
        this.damageCaused = 5;
        this.shape = new Rectangle(0, 0, size, size);
    }

}
