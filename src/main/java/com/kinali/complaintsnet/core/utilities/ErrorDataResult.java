package com.kinali.complaintsnet.core.utilities;

public class ErrorDataResult<T> extends  DataResult{
    public ErrorDataResult(Object data) {
        super(data, false);
    }

    public ErrorDataResult(Object data, String message) {
        super(data, false, message);
    }
}