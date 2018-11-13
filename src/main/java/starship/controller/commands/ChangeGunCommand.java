package starship.controller.commands;

import starship.controller.ShipController;

public class ChangeGunCommand extends Command {
    public ChangeGunCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.changeGun();
    }
}
