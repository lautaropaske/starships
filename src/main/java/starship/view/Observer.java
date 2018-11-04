package starship.view;

import starship.model.Observable;
import starship.model.Solid;

public interface Observer<T> {
    void update(Observable<T> observable);

    void update(Solid solid);
}
