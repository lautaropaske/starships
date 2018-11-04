package starship.model;

import starship.controller.model.ShipCommands;

public class Player {
    private String name;
    private ShipCommands commands;

    public Player(String name, ShipCommands commands) {
        this.name = name;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public ShipCommands getCommands() {
        return commands;
    }
}
