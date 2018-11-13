package starship.model.factories;

import starship.base.collision.CollisionManager;
import starship.base.main.ObjectManager;
import starship.base.vector.Vector2;
import starship.base.main.GraphicManager;
import starship.model.Asteroid;
import starship.view.AsteroidG;

import java.util.Random;
import java.util.UUID;

public class AsteroidFactory extends SolidFactory {
    public AsteroidFactory(ObjectManager om) {
        super(om);
    }

    /**
        Generate random position outside the screen. Lower bound for both X & Y is 0, so its not necessary to specify a low
        For the next equation: randomValue = r.nextInt(high-low) + low;
     */
    public void spawn(int amount) {
        for(; amount >= 0; amount-- ){

            Random r = new Random();
            int boundX = 80;
            int boundY = 60;

            float spawnX = -r.nextInt(boundX);
            float spawnY = -r.nextInt(boundY);

            if(r.nextBoolean()){
                spawnX *= -20;
                spawnY *= -20;
            }

            // Build asteroid
            String pairID = UUID.randomUUID().toString();

            Asteroid asteroid = new Asteroid(pairID,new Random().nextInt(4) * 40 + 20, Vector2.vector(spawnX,spawnY));
            AsteroidG asteroidG = new AsteroidG(pairID);
            asteroid.add(asteroidG);
            asteroidG.update(asteroid);
            notifyObserver(asteroid, asteroidG);
        }
    }
}
