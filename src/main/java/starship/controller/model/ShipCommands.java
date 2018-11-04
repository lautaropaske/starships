package starship.controller.model;

import processing.event.KeyEvent;
import starship.controller.model.commands.Command;

import java.util.List;
import java.util.Set;

public class ShipCommands {
    private Set<Command> commands;

    public ShipCommands(Set<Command> commands){
        this.commands = commands;
    }

    public void acceptKeyEvent(Integer k){
        commands.forEach(c -> {
            if (k == c.getKeyCode()) c.execute();
        });
    }
}
