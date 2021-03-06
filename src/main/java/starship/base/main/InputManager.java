package starship.base.main;


import starship.controller.ShipCommands;


import java.util.Set;

public class InputManager {

    private Set<ShipCommands> playersCommands;

    public InputManager(Set<ShipCommands> playersCommands) {
        this.playersCommands = playersCommands;
    }

    public void keysPressed(Set<Integer> keySet) {
        playersCommands.forEach(pc -> keySet.forEach(pc::acceptKeyEvent));
    }
}
