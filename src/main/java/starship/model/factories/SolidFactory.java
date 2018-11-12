package starship.model.factories;

import starship.base.collision.CollisionManager;
import starship.base.main.GraphicManager;
import starship.view.SolidG;

class SolidFactory {
    private GraphicManager observer;
    private CollisionManager observer2;

    SolidFactory(GraphicManager observer, CollisionManager observer2){
        this.observer = observer;
        this.observer2 = observer2;
    }

    void notifyObserver(SolidG graphic){
        observer.addGraphic(graphic);
        observer2.addCollisionable(graphic.getLastState());
    }
}
