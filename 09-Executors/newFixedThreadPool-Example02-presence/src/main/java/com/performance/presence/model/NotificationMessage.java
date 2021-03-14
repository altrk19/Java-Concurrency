package com.performance.presence.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("notificationMessage")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class NotificationMessage {
    private int statusCode;
    private String eventType;
    private String eventId;
    private String notificationChannelId;
    private String active;
    private String time;
    private String userId;
    private String deviceIdentifier;
    private PresenceWatcherNotificationParams presenceWatcherNotificationParams;

    public NotificationMessage() {
    }

    public NotificationMessage(int statusCode, String eventType, String eventId, String notificationChannelId,
                               String active, String time, String userId, String deviceIdentifier,
                               PresenceWatcherNotificationParams presenceWatcherNotificationParams) {
        this.statusCode = statusCode;
        this.eventType = eventType;
        this.eventId = eventId;
        this.notificationChannelId = notificationChannelId;
        this.active = active;
        this.time = time;
        this.userId = userId;
        this.deviceIdentifier = deviceIdentifier;
        this.presenceWatcherNotificationParams = presenceWatcherNotificationParams;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getNotificationChannelId() {
        return notificationChannelId;
    }

    public void setNotificationChannelId(String notificationChannelId) {
        this.notificationChannelId = notificationChannelId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public void setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public PresenceWatcherNotificationParams getPresenceWatcherNotificationParams() {
        return presenceWatcherNotificationParams;
    }

    public void setPresenceWatcherNotificationParams(
            PresenceWatcherNotificationParams presenceWatcherNotificationParams) {
        this.presenceWatcherNotificationParams = presenceWatcherNotificationParams;
    }
}

