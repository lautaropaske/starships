package starship.model.factories;

import starship.controller.model.ShipCommands;
import starship.model.Player;

public class PlayerFactory {

    public Player createPlayer(String name){
        return new Player(name);
    }
}
