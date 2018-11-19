package starship.model.factories;

import processing.core.PImage;
import starship.base.main.ObjectManager;
import starship.model.solids.Solid;
import starship.view.SolidG;

import java.util.Map;

class SolidFactory {
    final Map<String, PImage> images;
    final ObjectManager om;

    SolidFactory(ObjectManager om, Map<String, PImage> images){
        this.om = om;
        this.images = images;
    }

    void notifyObserver(Solid solid, SolidG solidG){
        om.addObject(solid, solidG);
    }
}
