package starship.view;

import starship.model.solids.Observable;

public interface Observer<T> {
    void update(Observable<T> observable);
}
