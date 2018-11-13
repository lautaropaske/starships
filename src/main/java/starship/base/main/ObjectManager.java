package starship.base.main;

import processing.core.PGraphics;
import starship.base.collision.CollisionManager;
import starship.base.vector.Vector2;
import starship.model.Solid;
import starship.view.SolidG;

public class ObjectManager {
    private CollisionManager cm;
    private GraphicManager gm;

    public ObjectManager(CollisionManager cm, GraphicManager gm, int screenX, int screenY) {
        cm.setScreenX(screenX);
        gm.setScreenX(screenX);
        cm.setScreenY(screenY);
        gm.setScreenY(screenY);

        this.cm = cm;
        this.gm = gm;
    }

    public void addObject(Solid solid, SolidG solidG){
        cm.addCollisionable(solid);
        gm.addGraphic(solidG);
    }

    public void loop(PGraphics p){
        cm.clean();
        gm.clean();
        cm.collide();
        gm.draw(p);
    }

    public static boolean isOutOfBounds(Vector2 position, int screenX, int screenY){
        return !(position.getX() > 0 && position.getX() < screenX) && !(position.getY() > 0 && position.getY() < screenY);
    }
}
