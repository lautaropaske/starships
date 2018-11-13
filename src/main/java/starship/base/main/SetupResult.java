package starship.base.main;

import starship.controller.ShipCommands;

import java.util.HashSet;
import java.util.Set;

public class SetupResult {
    private Set<ShipCommands> shipCommands;

    SetupResult(){
        this.shipCommands = new HashSet<>();
    }

    public void addShipCommand(ShipCommands shipCommand){
        shipCommands.add(shipCommand);
    }

    public Set<ShipCommands> getShipCommands(){
        return shipCommands;
    }

}
