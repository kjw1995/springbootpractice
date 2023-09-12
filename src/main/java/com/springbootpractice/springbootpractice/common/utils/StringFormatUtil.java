package com.springbootpractice.springbootpractice.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringFormatUtil {
    
    public static final String SIMPLE_FORMAT_YEARTOSECONDS = "yyyy-MM-dd HH:mm:ss";

    public static String LocalDateTimeNowToString(String format) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String resultFormat = LocalDateTime.now().format(formatter);


        return resultFormat;
    }
    

}
