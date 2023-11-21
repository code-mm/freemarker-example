package com.my.app.example3;


public class Entity {
    public String name;

    public String message;

    public String code;


    public Entity(String name, String message, int code) {
        this.name = name;
        this.message = message;
        this.code = String.valueOf(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
