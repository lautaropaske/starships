package starship.base.main;

import starship.base.collision.CollisionManager;
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
    private final GraphicManager gm;
    private final CollisionManager cm;

    public Game(GraphicManager gm, CollisionManager cm){
        this.shipFactory = new ShipFactory(gm, cm);
        this.asteroidFactory = new AsteroidFactory(gm, cm);
        this.playerFactory = new PlayerFactory();
        this.gm = gm;
        this.cm = cm;
    }

    public SetupResult setup(Set<String> names){
        SetupResult result = new SetupResult();

        names.forEach(name -> {
            Player player = playerFactory.createPlayer(name);
            ShipCommands shipCommands = createShipCommand(shipFactory.createShip(player, new BulletFactory(gm, cm)));
            player.setCommands(shipCommands);
            result.addShipCommand(shipCommands);
        });

        return result;
    }

    public void spawnAsteroids(){
        asteroidFactory.spawn(new Random().nextInt(1));
    }

    // TODO must read configuration from file and retrieve as many ShipCommand configurations as players supported
    private ShipCommands createShipCommand(Ship ship /*TODO , pass config reading and set of keys*/){
        Set<Command> commandSet = new HashSet<>();

        ShipController sc = new ShipController(ship);

        commandSet.add(new MoveUpCommand(sc, KeyEvent.VK_W));
        commandSet.add(new MoveLeftCommand(sc, KeyEvent.VK_A));
        commandSet.add(new MoveDownCommand(sc, KeyEvent.VK_S));
        commandSet.add(new MoveRightCommand(sc, KeyEvent.VK_D));
        commandSet.add(new FireGunCommand(sc, KeyEvent.VK_E));

        return new ShipCommands(commandSet);

    }
}
