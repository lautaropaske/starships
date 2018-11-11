package starship.controller.commands;

import starship.controller.ShipController;

public class MoveUpCommand extends Command {

    public MoveUpCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveUp();
    }
}
