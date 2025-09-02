package com.kh.homework0809.alarm;

import java.time.LocalDateTime;

public class HourSpecifyAlarm extends Alarm {
    private int targetHour;

    public HourSpecifyAlarm(int targetHour, String message, String link, boolean repeat) {
        super(AlarmType.HOUR_SPECIFY, message, link, repeat);
        this.targetHour = targetHour;
    }

    @Override
    public boolean inspect() {
        return LocalDateTime.now().getHour() == targetHour;
    }
}