package starship.model;

import starship.controller.ShipCommands;

public class Player {
    private String name;
    private ShipCommands commands;

    public Player(String name) {
        this.name = name;
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
}
