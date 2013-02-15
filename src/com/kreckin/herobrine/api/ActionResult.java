package com.kreckin.herobrine.api;

public class ActionResult {

    private final String data, message;
    
    public ActionResult(String message) {
        this(message, null);
    }
    
    public ActionResult(String message, String data) {
        this.message = message;
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }
}
