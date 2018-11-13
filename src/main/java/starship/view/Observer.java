package starship.view;

import starship.model.solids.Observable;
import starship.model.solids.Solid;

public interface Observer<T> {
    void update(Observable<T> observable);

    void update(Solid solid);
}
