package starship.controller.main;

import starship.controller.model.ShipCommands;
import starship.controller.model.ShipController;
import starship.controller.model.commands.*;
import starship.model.Ship;
import starship.model.factory.PlayerFactory;
import starship.model.factory.ShipFactory;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Game {
    private ShipFactory shipFactory;
    private PlayerFactory playerFactory;

    public Game(ShipFactory shipFactory, PlayerFactory playerFactory){
        this.shipFactory = shipFactory;
        this.playerFactory = playerFactory;
    }

    public SetupResult setup(Set<String> names){
        SetupResult result = new SetupResult();

        ShipCommands shipCommands = createShipCommand(shipFactory.createShip());

        names.forEach(name -> playerFactory.createPlayer(name, shipCommands));

        result.addShipCommand(shipCommands);

        return result;
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
