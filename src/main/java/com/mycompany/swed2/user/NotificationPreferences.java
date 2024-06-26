package com.mycompany.swed2.user;

import com.mycompany.swed2.notification.CommunicationChannel;
import com.mycompany.swed2.utils.Frequency;

public class NotificationPreferences {
    private Frequency frequency;
    private CommunicationChannel preferredChannel;

    public NotificationPreferences(Frequency frequency, CommunicationChannel preferredChannel) {
        this.frequency = frequency;
        this.preferredChannel = preferredChannel;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public CommunicationChannel getPreferredChannel() {
        return preferredChannel;
    }
}
