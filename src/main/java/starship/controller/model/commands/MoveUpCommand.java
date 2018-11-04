package starship.controller.model.commands;

import starship.controller.model.ShipController;

public class MoveUpCommand extends Command {

    public MoveUpCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveUp();
    }
}
