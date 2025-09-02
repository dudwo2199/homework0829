package com.kh.homework0809.alarm;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AlarmMgr {
    protected Map<AlarmType, Alarm> alarms = new HashMap<>();

    public void EntryAlarm(AlarmType type, Alarm alarm) {
        alarms.put(type, alarm);
    }

    public void inspector(AlarmType type) {
        Alarm alarm = alarms.get(type);
        if (alarm != null && alarm.inspect()) {
            if (alarm.repeat) {//!< 반복형
                if (alarm.triggeredDate == null || !alarm.triggeredDate.equals(LocalDateTime.now())) {
                    executeAlarm(alarm);
                    alarm.triggeredDate = LocalDateTime.now();
                }
            } else {//!< 일회성
                if (alarm.triggeredDate == null) {
                    executeAlarm(alarm);
                    alarm.triggeredDate = LocalDateTime.now();
                }
            }
        }
    }

    protected void executeAlarm(Alarm alarm) {
        System.out.println("알람: " + alarm.message + " 링크: " + alarm.link);
    }
}
