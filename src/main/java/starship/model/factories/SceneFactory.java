package starship.model.factories;

import processing.core.PImage;
import starship.base.main.ObjectManager;
import starship.view.Border;

import java.util.Map;

public class SceneFactory {

    private Map<String, PImage> images;
    private ObjectManager om;

    public SceneFactory(ObjectManager om, Map<String, PImage> images){
        this.om = om;
        this.images = images;
    }

    public Border createBorder() {
        Border border = new Border(om.getScreenX(), om.getScreenY());
        om.addDrawable(border);
        return border;
    }
}
