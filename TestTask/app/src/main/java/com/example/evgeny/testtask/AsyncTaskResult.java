package com.example.evgeny.testtask;

/**
 * Created by palevo on 07.05.2017.
 */

public class AsyncTaskResult<T> {
    private T result;
    private Exception error;

    public T getResult() {
        return result;
    }

    public Exception getError() {
        return error;
    }

    public AsyncTaskResult(T result) {
        super();
        this.result = result;
    }

    public AsyncTaskResult(Exception error) {
        super();
        this.error = error;
    }
}
