package starship.model.factories;

import starship.base.vector.Vector2;
import starship.controller.main.GraphicManager;
import starship.model.Asteroid;
import starship.view.AsteroidG;

import java.util.Random;

public class AsteroidFactory extends GraphicFactory {
    public AsteroidFactory(GraphicManager observer) {
        super(observer);
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
            Asteroid asteroid = new Asteroid(new Random().nextInt(4) * 40 + 20, Vector2.vector(spawnX,spawnY));
            AsteroidG asteroidG = new AsteroidG();
            asteroid.add(asteroidG);
            asteroidG.update(asteroid);
            notifyObserver(asteroidG);
        }
    }
}
