package starship.base.main;

import starship.controller.ShipCommands;
import starship.controller.ShipController;
import starship.controller.commands.*;
import starship.model.Player;
import starship.model.Ship;
import starship.model.factories.AsteroidFactory;
import starship.model.factories.BulletFactory;
import starship.model.factories.PlayerFactory;
import starship.model.factories.ShipFactory;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {
    private final AsteroidFactory asteroidFactory;
    private final ShipFactory shipFactory;
    private final PlayerFactory playerFactory;
    private final ObjectManager om;

    public Game(ObjectManager om){
        this.shipFactory = new ShipFactory(om);
        this.asteroidFactory = new AsteroidFactory(om);
        this.playerFactory = new PlayerFactory();
        this.om = om;
    }

    public SetupResult setup(Set<String> names){
        SetupResult result = new SetupResult();

        names.forEach(name -> {
            Player player = playerFactory.createPlayer(name);

            // TODO must read configuration from file and retrieve as many ShipCommand configurations as players supported
            int[] keys = new int[]{KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_E};

            Ship ship = shipFactory.createShip(player, new BulletFactory(om));

            ShipCommands shipCommands = createShipCommand(ship,keys);
            player.setCommands(shipCommands);
            result.addShipCommand(shipCommands);
        });

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

        return new ShipCommands(commandSet);

    }
}
