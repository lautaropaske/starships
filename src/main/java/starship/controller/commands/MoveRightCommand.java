package starship.controller.commands;

import starship.controller.ShipController;

public class MoveRightCommand extends Command {

    public MoveRightCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveRight();
    }
}
