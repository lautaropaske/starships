package starship.model.factory;

import starship.controller.model.ShipCommands;
import starship.model.Player;

public class PlayerFactory {

    public Player createPlayer(String name, ShipCommands shipCommands){
        return new Player(name, shipCommands);
    }
}
