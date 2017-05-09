package com.example.evgeny.testtask.observer;

/**
 * Created by palevo on 24.04.2017.
 */

public interface Observer {
    void objectCreated(Object obj);
    void objectModified(Object obj);
}
