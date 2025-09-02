package com.kh.homework0809;

import com.kh.homework0809.alarm.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homework0809Application {


	public static void main(String[] args) {

//		AlarmMgr alarmMgr = new AlarmMgr();

//		AlarmType type = AlarmType.HOUR_SPECIFY;
//		alarmMgr.EntryAlarm(type, AlarmEntry(type));

		SpringApplication.run(Homework0809Application.class, args);
	}

//	static Alarm AlarmEntry(AlarmType type) {
//        return switch (type) {
//            case HOUR_SPECIFY -> new HourSpecifyAlarm(9, "시간 알람", null, true);
//            case REPORT_THRESHOLD -> new ReportThresholdAlarm(5, "신고 알람", null, false);
//            default -> throw new IllegalArgumentException("Unknown alarm type: " + type);
//        };
//	}
}
