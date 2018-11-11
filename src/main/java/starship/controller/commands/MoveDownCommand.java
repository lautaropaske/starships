package starship.controller.commands;

import starship.controller.ShipController;

public class MoveDownCommand extends Command{

    public MoveDownCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.moveDown();
    }
}
