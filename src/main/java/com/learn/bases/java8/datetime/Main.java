package com.learn.bases.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
//        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
//        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
//
//        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
//        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
//                .with(TemporalAdjusters.firstDayOfMonth());
//
//        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
//        ZoneOffset offset = ZoneOffset.of("+02:00");
//
//        OffsetDateTime offSetByTwo = OffsetDateTime
//                .of(localDateTime, offset);
//
//        LocalDate initialDate = LocalDate.parse("2007-05-10");
//        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
//        long five = ChronoUnit.DAYS.between(initialDate, finalDate);
//
//        long ml = System.currentTimeMillis();
//        LocalDateTime.ofEpochSecond(ml, 0, ZoneOffset.UTC);

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);

        String result = localDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                        .withLocale(Locale.CANADA))
                ;
    }
}
