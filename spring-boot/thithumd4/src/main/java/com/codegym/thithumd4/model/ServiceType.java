package com.codegym.thithumd4.model;


import lombok.Getter;

@Getter
public enum ServiceType {
    LAND("Đất"),
    REAL_ESTATE("Nhà đất");
    private final String vietnamese;

    ServiceType(String vietnamese) {
        this.vietnamese = vietnamese;
    }

}
