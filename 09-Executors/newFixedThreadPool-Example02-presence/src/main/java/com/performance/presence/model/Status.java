package com.performance.presence.model;

public enum Status {
    OPEN("Open"),
    CLOSED("Closed");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
