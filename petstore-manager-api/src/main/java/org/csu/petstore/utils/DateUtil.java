package org.csu.petstore.utils;

import java.util.Date;

public class DateUtil {

    public static Long getCurrentTimeStamp() {
        Date curDate = new Date();
        return curDate.getTime();
    }
}
