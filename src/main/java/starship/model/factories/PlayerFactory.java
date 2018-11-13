package starship.model.factories;

import starship.base.main.ObjectManager;
import starship.model.Player;
import starship.view.PlayerG;

public class PlayerFactory {

    private ObjectManager om;

    public PlayerFactory(ObjectManager om){
        this.om = om;
    }

    public Player createPlayer(String name, int playerNumber){
        Player player = new Player(name, playerNumber);
        int[] drawCoordinate = calculateDrawCoordinate(playerNumber);
        PlayerG playerG = new PlayerG(drawCoordinate[0], drawCoordinate[1]);
        player.add(playerG);
        playerG.update(player);
        om.addDrawable(playerG);
        return player;
    }

    private int[] calculateDrawCoordinate(int playerNumber){
        int[] coordinate = new int[2];

        int drawSpaceX = om.getScreenX() / 4;
        int drawSpaceY = om.getScreenY() / 4;

        coordinate[0] = (playerNumber-1) * drawSpaceX;
        if(playerNumber > 4) {
            coordinate[0] = (playerNumber-5) * drawSpaceX;
            coordinate[1] = (playerNumber-1) * drawSpaceY;
        }

        return coordinate;
    }
}
