package starship.controller.main;


import starship.controller.model.ShipCommands;


import java.util.Set;

public class InputManager {

    private Set<ShipCommands> playersCommands;

    public InputManager(Set<ShipCommands> playersCommands) {
        this.playersCommands = playersCommands;
    }

    public void keyPressed(Set<Integer> keySet) {
        playersCommands.forEach(pc -> keySet.forEach(pc::acceptKeyEvent));
    }
}
