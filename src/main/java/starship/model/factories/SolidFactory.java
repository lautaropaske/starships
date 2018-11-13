package starship.model.factories;

import starship.base.collision.CollisionManager;
import starship.base.main.GraphicManager;
import starship.base.main.ObjectManager;
import starship.model.Solid;
import starship.view.SolidG;

class SolidFactory {
    protected ObjectManager om;

    SolidFactory(ObjectManager om){
        this.om = om;
    }

    void notifyObserver(Solid solid, SolidG solidG){
        om.addObject(solid, solidG);
    }
}
