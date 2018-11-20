package starship.model.factories;

import processing.core.PImage;
import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.model.solids.Asteroid;
import starship.view.AsteroidG;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class AsteroidFactory extends SolidFactory {
    private final int screenX;
    private final int screenY;

    public AsteroidFactory(ObjectManager om, Map<String, PImage> images) {
        super(om, images);
        this.screenX = om.getScreenX();
        this.screenY = om.getScreenY();
    }

    /**
        Generate random position outside the screen. Lower bound for both X & Y is 0, so its not necessary to specify a low
        For the next equation: randomValue = r.nextInt(high-low) + low;
     */
    public void spawn(int amount) {
        for(; amount >= 0; amount-- ){
            Random r = new Random();
            int boundX = Math.round(screenX/20f);
            int boundY = Math.round(screenY/20f);

            float spawnX = r.nextInt(boundX);
            float spawnY = r.nextInt(boundY);

            if(r.nextBoolean()) spawnX = screenX - spawnX;
            if(r.nextBoolean()) spawnY = screenY - spawnY;

            // Build asteroid
            String pairID = UUID.randomUUID().toString();

            Asteroid asteroid = new Asteroid(pairID,new Random().nextInt(4) * 40 + 20, Vector2.vector(spawnX,spawnY));
            AsteroidG asteroidG = new AsteroidG(pairID, this.images.get("asteroid"));
            asteroid.add(asteroidG);
            asteroidG.update(asteroid);
            notifyObserver(asteroid, asteroidG);
        }
    }
}
