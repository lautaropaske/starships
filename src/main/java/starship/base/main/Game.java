package starship.base.main;

import starship.controller.ShipCommands;
import starship.controller.ShipController;
import starship.controller.commands.*;
import starship.model.Player;
import starship.model.solids.Ship;
import starship.model.factories.*;
import util.ConfigurationReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Game {
    private final AsteroidFactory asteroidFactory;
    private final ShipFactory shipFactory;
    private final PlayerFactory playerFactory;
    private final PowerUpFactory powerUpFactory;
    private final ObjectManager om;

    public Game(ObjectManager om){
        this.shipFactory = new ShipFactory(om);
        this.asteroidFactory = new AsteroidFactory(om);
        this.playerFactory = new PlayerFactory();
        this.powerUpFactory = new PowerUpFactory(om);
        this.om = om;
    }

    public SetupResult setup(Set<String> names){
        ConfigurationReader cr = new ConfigurationReader();
        Iterator<int[]> keySet = cr.getKeySet().iterator();


        SetupResult result = new SetupResult();

        names.forEach(name -> {
            Player player = playerFactory.createPlayer(name);
            Ship ship = shipFactory.createShip(player, new BulletFactory(om));
            ShipCommands shipCommands = createShipCommand(ship,keySet.next());
            player.setCommands(shipCommands);
            result.addShipCommand(shipCommands);
        });

        return result;
    }

    public void spawnAsteroids(){
        asteroidFactory.spawn(new Random().nextInt(2));
    }
    public void spawnPowerUp(){
        powerUpFactory.spawnDoubleFire();
    }

    private ShipCommands createShipCommand(Ship ship, int[] keys){
        Set<Command> commandSet = new HashSet<>();

        ShipController sc = new ShipController(ship);

        commandSet.add(new MoveUpCommand(sc, keys[0]));
        commandSet.add(new MoveLeftCommand(sc, keys[1]));
        commandSet.add(new MoveDownCommand(sc, keys[2]));
        commandSet.add(new MoveRightCommand(sc, keys[3]));
        commandSet.add(new FireGunCommand(sc, keys[4]));

        return new ShipCommands(commandSet);

    }
}
