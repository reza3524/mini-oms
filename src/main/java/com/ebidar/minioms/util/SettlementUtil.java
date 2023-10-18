package com.ebidar.minioms.util;

import com.ebidar.minioms.enumeration.SettlementType;
import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

@UtilityClass
public class SettlementUtil {

    public Timestamp handleType(SettlementType type) {
        Calendar calendar = new GregorianCalendar();
        Timestamp current = new Timestamp(calendar.getTime().getTime());
        return switch (type) {
            case T0 -> getDateAfterCurrent(current, 0);
            case T1 -> getDateAfterCurrent(current, 1);
            case T2 -> getDateAfterCurrent(current, 2);
            case T3 -> getDateAfterCurrent(current, 3);
        };
    }

    private Timestamp getDateAfterCurrent(Timestamp currentDate, Integer count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + count);
        return Timestamp.from(Instant.ofEpochMilli(calendar.getTimeInMillis()));
    }
}
