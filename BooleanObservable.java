import java.util.ArrayList;
import java.util.List;

public class BooleanObservable implements Observable {
    List<Observer> observers = new ArrayList<>();
    private boolean bool;

    public BooleanObservable(boolean bool) {
        this.bool = bool;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        observers.forEach(o -> o.update());
    }

    public void toggleBool() {
        this.bool = !this.bool;
    }

    public void set(boolean bool) {
        this.bool = bool;
    }

    public boolean get() {
        return this.bool;
    }
}