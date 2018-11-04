package starship.controller.model.commands;

import starship.controller.model.ShipController;

public class FireGunCommand extends Command {

    public FireGunCommand(ShipController sc, int keyCode) {
        super(sc, keyCode);
    }

    @Override
    public void execute() {
        sc.fireGun();
    }
}
