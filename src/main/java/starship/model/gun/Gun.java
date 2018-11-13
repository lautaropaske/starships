package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;

public interface Gun{
    void fireGun(Player player, Vector2 position, float shipHeading);
}
