package com.kh.homework0809.alarm;

public class ReportThresholdAlarm extends Alarm {
    private int reportThreshold;
    private int currentReportCount; //!< db 에서 가져오는걸로

    public ReportThresholdAlarm(int reportThreshold, String message, String link, boolean repeat) {
        super(AlarmType.REPORT_THRESHOLD, message, link, repeat);
        this.currentReportCount = 0;
        this.reportThreshold = reportThreshold;
    }

    @Override
    public boolean inspect() {
        return  currentReportCount >= reportThreshold;
    }
}
