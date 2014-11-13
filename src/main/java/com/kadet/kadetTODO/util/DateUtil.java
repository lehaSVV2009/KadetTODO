package com.kadet.kadetTODO.util;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Alex Soroka
 */
@Service
public class DateUtil {

    public Long longFromDate (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, date.getHours());
        calendar.set(Calendar.DST_OFFSET, date.getMinutes());
        calendar.set(Calendar.ZONE_OFFSET, date.getSeconds());
        return calendar.getTimeInMillis();
    }

}
