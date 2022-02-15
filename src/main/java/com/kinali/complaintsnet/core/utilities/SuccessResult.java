package com.kinali.complaintsnet.core.utilities;

public class SuccessResult extends Result{

    public SuccessResult() {
        super(true);
    }

    public SuccessResult( String message) {
        super(true, message);
    }
}
