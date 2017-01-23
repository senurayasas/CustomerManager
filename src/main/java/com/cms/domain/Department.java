package com.cms.domain;

public enum Department {

    PROMOTIONS("PROMOTIONS"),
    ADMINISTRATIONS("ADMINISTRATIONS"),
    ENGINEERING("ENGINEERING"),
    SALES("SALES"),
    SUPPORT("SUPPORT");

    private String id;

    private Department(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
