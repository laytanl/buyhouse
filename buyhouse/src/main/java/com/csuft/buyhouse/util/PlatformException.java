package com.csuft.buyhouse.util;

public class PlatformException extends RuntimeException {
    public PlatformException() {
        super();
    }


    public PlatformException(String message) {
        super(message);
    }

    public PlatformException(String message, Throwable e){
        super(message,e);
    }
}
