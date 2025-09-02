package com.kh.homework0809.alarm;

import java.time.LocalDateTime;

public abstract class Alarm {
    protected AlarmType alarmType;
    protected String message;
    protected String link;
    protected boolean repeat;
    protected LocalDateTime triggeredDate;

    public Alarm(AlarmType alarmType, String message, String link, boolean repeat) {
        this.alarmType = alarmType;
        this.message = message;
        this.link = link;
        this.repeat = repeat;
        this.triggeredDate = null;
    }

    public abstract boolean inspect();
}
