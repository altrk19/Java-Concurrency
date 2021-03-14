package com.performance.presence.model;

public class PresenceWatcherNotificationParams {
    private String name;
    private String status;
    private String note;
    private String type;

    public PresenceWatcherNotificationParams() {
    }

    public PresenceWatcherNotificationParams(String name, String status, String note, String type) {
        this.name = name;
        this.status = status;
        this.note = note;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
