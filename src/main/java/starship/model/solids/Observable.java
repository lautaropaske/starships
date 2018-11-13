package starship.model.solids;

import starship.view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
    List<Observer<T>> observers;

    public Observable(){
        observers = new ArrayList<>();
    }

    protected void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public void add(Observer<T> observer) {
        observers.add(observer);
    }

    public boolean delete(Observer<T> observer) {
        if(observers.contains(observer)){
            return observers.remove(observer);
        } else return false;
    }
}
