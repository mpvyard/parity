package com.paritytrading.parity.reporter;

import com.paritytrading.foundation.ASCII;
import com.paritytrading.parity.util.Timestamps;
import java.util.Locale;

class Formats {

    public static double formatPrice(long price) {
        return price / 10_000.0;
    }

    public static String formatString(long instrument) {
        return ASCII.unpackLong(instrument).trim();
    }

    public static String formatTimestamp(long timestamp) {
        return Timestamps.format(timestamp / 1_000_000);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(Locale.US, format, args);
    }

}
