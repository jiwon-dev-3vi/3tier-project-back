package com.example.project.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 시간(LocalDateTiem, DateTime, ..) 포맷에 대한 util함수 입니다. 
 * 
 * 시간을 프론트가 원하는 형태로 변경해야하는 경우가 많을 것이라고 판단하여 추가해주었습니다.  
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeUtils {
    // "yyyy-MM-dd" 포맷 (날짜만)
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    // "yyyy-MM-dd HH:mm" 포맷 (날짜와 시간(분))
    public static final DateTimeFormatter DATE_TIME_MINUTE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // "yyyy-MM-dd HH:mm:ss" 포맷 (날짜와 시간(분, 초)
    public static final DateTimeFormatter DATE_TIME_SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * LocalDateTime을 "yyyy-MM-dd" 형식으로 포맷합니다.
     *
     * @param localDateTime 포맷할 LocalDateTime 객체 ('yyyy-MM-dd'T'HH:mm:ss')
     * @return "yyyy-MM-dd"
     */
    public static String formatToDate(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_FORMATTER);
    }

    /**
     * LocalDateTime을 "yyyy-MM-dd HH:mm" 형식으로 포맷합니다.
     *
     * @param localDateTime 포맷할 LocalDateTime 객체
     * @return "yyyy-MM-dd HH:mm"
     */
    public static String formatToDateTimeWithMinutes(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_MINUTE_FORMATTER);
    }

    /**
     * LocalDateTime을 "yyyy-MM-dd HH:mm:ss" 형식으로 포맷합니다.
     *
     * @param localDateTime 포맷할 LocalDateTime 객체
     * @return "yyyy-MM-dd HH:mm:ss"
     */
    public static String formatToDateTimeWithSeconds(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_SECOND_FORMATTER);
    }
}