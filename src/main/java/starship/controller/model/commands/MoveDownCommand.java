package starship.controller.model.commands;

import starship.controller.model.ShipController;

public class MoveDownCommand extends Command{

    public MoveDownCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveDown();
    }
}
