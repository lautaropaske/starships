package starship;

import processing.core.*;
import starship.base.collision.CollisionManager;
import starship.base.framework.GameFramework;
import starship.base.framework.ImageLoader;
import starship.base.framework.WindowSettings;
import processing.event.KeyEvent;
import starship.base.main.*;

import java.util.HashSet;
import java.util.Set;

public class CustomGameFramework implements GameFramework {

    //GAME VALUES
    private final int screenX;
    private final int screenY;
    private ObjectManager om;
    private Game game;
    private InputManager im;
    private float spawnAsteroidsClock;
    private float spawnPowerUpClock;

    public CustomGameFramework(){
        this.screenX = 1000;
        this.screenY = 800;
        this.om = new ObjectManager(new CollisionManager(), new GraphicManager(), this.screenX, this.screenY);
        this.spawnAsteroidsClock = 1000f;
        this.spawnPowerUpClock = 100000f;
        this.game = new Game(om);
    }

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(this.screenX, this.screenY);

        //TODO has to have an initial input controller to check for name input and set game configuration previous to initialization of a match

        Set<String> names = new HashSet<>();
        names.add("Player1");
        names.add("Player2");

        SetupResult setupResult = game.setup(names);

        this.im = new InputManager(setupResult.getShipCommands());
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        graphics.background(255,255,255);

        if(spawnPowerUpClock >= 100000f){
            game.spawnPowerUp();
            spawnPowerUpClock = 0;
        } else {
            spawnPowerUpClock += timeSinceLastDraw;
        }

        if(spawnAsteroidsClock >= 1500f){
            game.spawnAsteroids();
            spawnAsteroidsClock = 0;
        } else {
            spawnAsteroidsClock += timeSinceLastDraw;
        }

        this.om.clean();
        this.om.loop(graphics);
        this.im.keysPressed(keySet);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // None
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // None
    }
}
