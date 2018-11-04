package starship;

import processing.core.PConstants;
import starship.base.framework.GameFramework;
import starship.base.framework.ImageLoader;
import starship.base.framework.WindowSettings;
import processing.core.PGraphics;
import processing.event.KeyEvent;
import starship.controller.main.Game;
import starship.controller.main.GraphicManager;
import starship.controller.main.InputManager;
import starship.controller.main.SetupResult;
import starship.model.factory.PlayerFactory;
import starship.model.factory.ShipFactory;

import java.util.HashSet;
import java.util.Set;

public class CustomGameFramework implements GameFramework {
    private GraphicManager gm;
    private Game game;
    private InputManager im;

    public CustomGameFramework(){
        this.gm = new GraphicManager();

        ShipFactory shipFactory = new ShipFactory(this.gm);
        PlayerFactory playerFactory = new PlayerFactory();
        this.game = new Game(shipFactory, playerFactory);
    }

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(800, 600);

        //TODO has to have an initial input controller to check for name input and set game configuration previous to initialization of a match

        Set<String> names = new HashSet<>();
        names.add("Player1");

        SetupResult setupResult = game.setup(names);

        this.im = new InputManager(setupResult.getShipCommands());
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        graphics.background(0);
        graphics.rectMode(PConstants.CENTER);

        this.gm.draw(graphics);
        this.im.keyPressed(keySet);
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
