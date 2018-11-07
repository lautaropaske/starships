package starship.model.factories;

import starship.controller.main.GraphicManager;
import starship.view.SolidG;

public class GraphicFactory {
    private GraphicManager observer;

    public GraphicFactory(GraphicManager observer){
        this.observer = observer;
    }

    protected void notifyObserver(SolidG graphic){
        observer.addGraphic(graphic);
    }
}
