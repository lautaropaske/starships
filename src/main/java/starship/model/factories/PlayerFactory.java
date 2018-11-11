package starship.model.factories;

import starship.model.Player;

public class PlayerFactory {

    public Player createPlayer(String name){
        return new Player(name);
    }
}
