package starship.base.main;

import processing.core.PImage;
import starship.controller.ShipCommands;

import java.util.HashSet;
import java.util.Set;

public class SetupResult {
    private Set<ShipCommands> shipCommands;
    private PImage background;

    SetupResult(){
        this.shipCommands = new HashSet<>();
    }

    public void addShipCommand(ShipCommands shipCommand){
        shipCommands.add(shipCommand);
    }

    public Set<ShipCommands> getShipCommands(){
        return shipCommands;
    }

    public void setBackground(PImage image){
        this.background = image;
    }
    public PImage getBackground() {
        return background;
    }
}
