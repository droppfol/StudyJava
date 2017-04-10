package spies;

public interface Observable
{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Observer observer, Message message);
}
