package starship.model;

import starship.controller.ShipCommands;
import starship.model.solids.Observable;

public class Player extends Observable<Player> {
    private String name;
    private int playerNumber;
    private int score;
    private ShipCommands commands;

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setCommands(ShipCommands commands) {
        this.commands = commands;
    }

    public ShipCommands getCommands() {
        return commands;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Player) obj).name);
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getScore() {
        return score;
    }

    public void scored(int size) {
        this.score += size;
    }
}
