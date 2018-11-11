package starship.model.factories;

import starship.base.collision.GraphicManager;
import starship.view.SolidG;

class GraphicFactory {
    private GraphicManager observer;

    GraphicFactory(GraphicManager observer){
        this.observer = observer;
    }

    void notifyObserver(SolidG graphic){
        observer.addGraphic(graphic);
        observer.addCollisionable(graphic.getLastState());
    }
}
