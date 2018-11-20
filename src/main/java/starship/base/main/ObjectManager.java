package starship.base.main;

import processing.core.PGraphics;
import starship.base.collision.CollisionManager;
import starship.base.vector.Vector2;
import starship.controller.ShipController;
import starship.model.solids.Solid;
import starship.view.Drawable;
import starship.view.SolidG;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private CollisionManager cm;
    private GraphicManager gm;
    private int screenX;
    private int screenY;

    public ObjectManager(CollisionManager cm, GraphicManager gm, int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;

        cm.setScreenX(screenX);
        gm.setScreenX(screenX);
        cm.setScreenY(screenY);
        gm.setScreenY(screenY);

        this.cm = cm;
        this.gm = gm;
    }

    public void addObject(Solid solid, SolidG solidG){
        cm.addCollisionable(solid);
        gm.addSolidG(solidG);
    }

    /**
     * For elements without a collisionable representation, i.e PlayerG
     * */
    public void addDrawable(Drawable drawable){
        gm.addDrawable(drawable);
    }

    public void clean(){
        cm.clean();
        gm.clean();
    }
    public void loop(PGraphics p){
        cm.collide();
        gm.draw(p);
    }

    public static boolean isOutOfBounds(Vector2 position, int screenX, int screenY){
        return !(position.getX() >= 0 && position.getX() <= screenX) || !(position.getY() >= 0 && position.getY() <= screenY);
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }
}
