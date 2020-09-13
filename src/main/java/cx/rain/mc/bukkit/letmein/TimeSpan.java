package cx.rain.mc.bukkit.letmein;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeSpan {
    private LocalTime start;
    private LocalTime end;

    private boolean inTwoDays;

    public TimeSpan(String s, String e) {
        start = LocalTime.parse(s, DateTimeFormatter.ofPattern("HH:mm:ss"));
        end = LocalTime.parse(e, DateTimeFormatter.ofPattern("HH:mm:ss"));

        inTwoDays = start.isAfter(end);
    }

    public boolean isInSpan(LocalTime now) {
        if (inTwoDays) {
            return !(now.isAfter(end) && now.isBefore(start));
        } else {
            return now.isBefore(end) && now.isAfter(start);
        }
    }
}
