package com.example.evgeny.testtask.observer;

/**
 * Created by palevo on 05.05.2017.
 */

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
