package starship.model.solids.bullets;

import starship.base.vector.Vector2;

import java.awt.*;

public abstract class Bullet{
    public int damageCaused;
    int hp;
    int size;
    Vector2 velocity;
    Shape shape;
}
