package com.example.evgeny.testtask.observer;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by palevo on 24.04.2017.
 */

public class Observers<T extends Observer> extends ArrayList<T> {
    public void notifyObjectCreated(Object obj) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().objectCreated(obj);
    }
    public void notifyObjectModified(Object obj) {
        for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
            iter.next().objectModified(obj);
    }
}
