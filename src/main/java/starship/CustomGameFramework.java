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
    private PImage background;

    public CustomGameFramework(){
        this.screenX = 1400;
        this.screenY = 1000;
        this.om = new ObjectManager(new CollisionManager(), new GraphicManager(), this.screenX, this.screenY);
        this.spawnAsteroidsClock = 1000f;
    }

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        this.game = new Game(om, imageLoader);

        windowsSettings
            .setSize(this.screenX, this.screenY);

        Set<String> names = new HashSet<>();
        names.add("Player1");
        names.add("Player2");

        SetupResult setupResult = game.setup(names);

        this.im = new InputManager(setupResult.getShipCommands());
        this.background = setupResult.getBackground();
        background.resize(screenX,screenY);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        graphics.background(background);

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
