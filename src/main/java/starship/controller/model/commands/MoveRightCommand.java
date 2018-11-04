package starship.controller.model.commands;

import starship.controller.model.ShipController;

public class MoveRightCommand extends Command {

    public MoveRightCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveRight();
    }
}
