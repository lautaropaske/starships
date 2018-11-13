package starship.model.factories;

import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.model.solids.powerups.DoubleFirePowerUp;
import starship.model.solids.powerups.PowerUp;
import starship.view.PowerUpG;

import java.util.Random;
import java.util.UUID;

public class PowerUpFactory extends SolidFactory{
    private final int screenX;
    private final int screenY;

    public PowerUpFactory(ObjectManager om) {
        super(om);
        this.screenX = om.getScreenX();
        this.screenY = om.getScreenY();
    }

    /**
     Generate random position outside the screen. Lower bound for both X & Y is 0, so its not necessary to specify a low
     For the next equation: randomValue = r.nextInt(high-low) + low;
     */
    public void spawnDoubleFire() {
        Random r = new Random();

        float spawnX = r.nextInt(screenX);
        float spawnY = r.nextInt(screenY);

        // Build powerUp
        String pairID = UUID.randomUUID().toString();

        PowerUp powerUp = new DoubleFirePowerUp(pairID, Vector2.vector(spawnX, spawnY));
        PowerUpG powerUpG = new PowerUpG(pairID);
        powerUp.add(powerUpG);
        powerUpG.update(powerUp);
        notifyObserver(powerUp, powerUpG);
    }
}
