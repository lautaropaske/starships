package starship.model;

import starship.controller.ShipCommands;
import starship.model.solids.Observable;

public class Player extends Observable<Player> {
    private String name;
    private int playerNumber;
    private int score;
    private int lives;
    private ShipCommands commands;

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.score = 0;
        this.lives = 3;
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

    public void scored(int amount) {
        this.score += amount;
    }

    public int getLives(){
        return lives;
    }

    public void lostLife(){
        this.lives -= 1;
    }


}
