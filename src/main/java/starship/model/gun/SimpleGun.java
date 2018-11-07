package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;
import starship.model.factories.BulletFactory;

public class SimpleGun implements Gun{
    private BulletFactory bulletFactory;

    @Override
    public void fireGun(Player player, Vector2 position) {
        bulletFactory.spawnSimpleBullet(player, position);
    }
}
