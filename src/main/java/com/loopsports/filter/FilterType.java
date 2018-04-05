package com.loopsports.filter;

public enum FilterType {

    PRE("pre"),
    ROUTING("routing"),
    POST ("post"),
    ERROR("error");


    private final String type;

    FilterType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
