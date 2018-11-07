package starship.model.gun;

import starship.base.vector.Vector2;
import starship.model.Player;

public interface Gun{
    void fireGun(Player player, Vector2 position);
}
