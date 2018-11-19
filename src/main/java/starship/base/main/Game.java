package starship.base.main;

import processing.core.PImage;
import starship.base.framework.ImageLoader;
import starship.controller.ShipCommands;
import starship.controller.ShipController;
import starship.controller.commands.*;
import starship.model.Player;
import starship.model.solids.Ship;
import starship.model.factories.*;
import util.ConfigurationReader;

import java.util.*;

public class Game {
    private final SceneFactory sceneFactory;
    private final AsteroidFactory asteroidFactory;
    private final ShipFactory shipFactory;
    private final PlayerFactory playerFactory;
    private final ObjectManager om;
    private final ImageLoader loader;

    public Game(ObjectManager om, ImageLoader loader){
        Map<String, PImage> sceneImages = new HashMap<>();
        // None for the moment
        this.sceneFactory = new SceneFactory(om, sceneImages);

        Map<String, PImage> shipImages = new HashMap<>();
        shipImages.put("ship", loader.load(".\\util\\img\\ship.png"));
        this.shipFactory = new ShipFactory(om, shipImages);

        Map<String, PImage> asteroidImages = new HashMap<>();
        asteroidImages.put("asteroid", loader.load(".\\util\\img\\asteroid.png"));
        this.asteroidFactory = new AsteroidFactory(om, asteroidImages);

        Map<String, PImage> playerImages = new HashMap<>();
        /* Not rendering, could though*/
        this.playerFactory = new PlayerFactory(om, playerImages);
        this.om = om;
        this.loader = loader;
    }

    public SetupResult setup(Set<String> names){
        sceneFactory.createBorder();

        ConfigurationReader cr = new ConfigurationReader();
        Iterator<int[]> keySet = cr.getKeySet().iterator();
        Iterator<String> nameIterator = names.iterator();

        Map<String, PImage> bulletImages = new HashMap<>();
        bulletImages.put("simpleBullet", loader.load(".\\util\\img\\simpleBullet.jpg"));
        bulletImages.put("rocketBullet", loader.load(".\\util\\img\\rocketBullet.png"));

        SetupResult result = new SetupResult();
        result.setBackground(loader.load(".\\util\\img\\background.jpg"));

        for (int playerNumber = names.size(); playerNumber > 0;playerNumber--){
            Player player = playerFactory.createPlayer(nameIterator.next(), playerNumber);
            Ship ship = shipFactory.createShip(player, new BulletFactory(om, bulletImages));
            ShipCommands shipCommands = createShipCommand(ship,keySet.next());
            player.setCommands(shipCommands);
            result.addShipCommand(shipCommands);
        }

        return result;
    }

    public void spawnAsteroids(){
        asteroidFactory.spawn(new Random().nextInt(2));
    }

    private ShipCommands createShipCommand(Ship ship, int[] keys){
        Set<Command> commandSet = new HashSet<>();

        ShipController sc = new ShipController(ship);

        commandSet.add(new MoveUpCommand(sc, keys[0]));
        commandSet.add(new MoveLeftCommand(sc, keys[1]));
        commandSet.add(new MoveDownCommand(sc, keys[2]));
        commandSet.add(new MoveRightCommand(sc, keys[3]));
        commandSet.add(new FireGunCommand(sc, keys[4]));
        commandSet.add(new ChangeGunCommand(sc, keys[5]));

        return new ShipCommands(commandSet);

    }
}
