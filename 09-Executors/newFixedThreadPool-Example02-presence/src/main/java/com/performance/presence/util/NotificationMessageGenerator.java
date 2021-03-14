package com.performance.presence.util;

import com.performance.presence.model.ActivityValue;
import com.performance.presence.model.NotificationMessage;
import com.performance.presence.model.PresenceWatcherNotificationParams;
import com.performance.presence.model.Status;

public class NotificationMessageGenerator {
    public static NotificationMessage generateNotificationMessage(String receiverUserId, String senderName) {
        return new NotificationMessage(0, "presenceWatcher", "4033476449519842730", "simulator", "true",
                String.valueOf(System.currentTimeMillis()), receiverUserId, "simulator",
                new PresenceWatcherNotificationParams(senderName.concat("@rbbn.com"), Status.OPEN.getStatus(),
                        ActivityValue.getRandomActivity(), "SipTrunk"));
    }
}
