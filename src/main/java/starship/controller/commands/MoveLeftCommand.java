package starship.controller.commands;

import starship.controller.ShipController;

public class MoveLeftCommand extends Command {

    public MoveLeftCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveLeft();
    }
}
