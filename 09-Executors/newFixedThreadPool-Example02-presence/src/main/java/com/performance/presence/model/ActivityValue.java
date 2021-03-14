package com.performance.presence.model;

import java.util.*;

public enum ActivityValue {
    UNKNOWN("ActivitiesUnknown"),
    AVAILABLE("Available"),
    BUSY("Busy"),
    LUNCH("Lunch"),
    AWAY("Away"),
    VACATION("Vacation"),
    ON_THE_PHONE("OnThePhone"),
    OTHER("ActivitiesOther");

    static List<String> activities = new ArrayList<>();
    private static Random random = new Random();

    static {
        for (ActivityValue activityValue : ActivityValue.values()) {
            activities.add(activityValue.activity);
        }
    }
    private String activity;

    ActivityValue(String activity) {
        this.activity = activity;
    }

    public static String getRandomActivity() {
        return activities.get(random.nextInt(activities.size() - 1));
    }
}