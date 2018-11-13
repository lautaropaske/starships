package starship.model.solids.powerups;

import starship.base.vector.Vector2;
import starship.model.gun.DoubleFire;
import starship.model.gun.Gun;
import starship.model.visitors.PowerUpVisitor;

public class DoubleFirePowerUp extends PowerUp {
    public DoubleFirePowerUp(String pairID, Vector2 position) {
        super(pairID, position);
    }

    @Override
    public void setDecorator(Gun gun) {
        this.decorator = new DoubleFire(gun, pairID, position);
    }
}
