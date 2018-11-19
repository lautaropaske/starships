package starship.model.factories;

import processing.core.PImage;
import starship.base.main.ObjectManager;
import starship.model.Player;
import starship.view.PlayerG;

import java.util.Map;

public class PlayerFactory {

    private ObjectManager om;
    private Map<String, PImage> images;

    public PlayerFactory(ObjectManager om, Map<String, PImage> images){
        this.om = om;
        this.images = images;
    }

    public Player createPlayer(String name, int playerNumber){
        Player player = new Player(name, playerNumber);
        int[] drawCoordinate = calculateDrawCoordinate(playerNumber);
        PlayerG playerG = new PlayerG(drawCoordinate[0], drawCoordinate[1], om.getScreenX()/4);
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
        coordinate[1] = 0;

        if(playerNumber > 4) {
            coordinate[0] = (playerNumber-5) * drawSpaceX;
            coordinate[1] = (playerNumber-1) * drawSpaceY;
        }

        coordinate[0] += Math.round(om.getScreenX()/25f); // Border size
        coordinate[1] += Math.round(om.getScreenX()/25f); // Border size
        return coordinate;
    }
}
