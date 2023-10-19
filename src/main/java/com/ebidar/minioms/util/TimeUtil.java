package com.ebidar.minioms.util;

import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@UtilityClass
public class TimeUtil {

    public Timestamp getCurrent() {
        return new Timestamp(new GregorianCalendar().getTime().getTime());
    }

    public List<Timestamp> getCurrentTimeBetweenOneMinute() {
        List<Timestamp> timestamps = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCurrent());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        timestamps.add(Timestamp.from(Instant.ofEpochMilli(calendar.getTimeInMillis())));
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        timestamps.add(Timestamp.from(Instant.ofEpochMilli(calendar.getTimeInMillis())));
        return timestamps;
    }
}
