package org.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.TimeZone;

public class Teste {

    public static void main(String[] args) {
        Locale locBR = new Locale("pt", "BR");
        Locale locUS = new Locale("US");
        Locale locKR = new Locale("ko", "KR");

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(zonedDateTime.format(formatter));
    }

}
