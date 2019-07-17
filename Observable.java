import java.util.ArrayList;

interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}