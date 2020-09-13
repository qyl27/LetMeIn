package cx.rain.mc.bukkit.letmein;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeUtil {
    private static FileConfiguration config = null;
    private static List<TimeSpan> timeSpans = new ArrayList<>();

    public static void init() {
        config = LetMeIn.INSTANCE.getConfig();

        for (String s : config.getConfigurationSection("timespans").getKeys(false)) {
            String start = config.getString("timespans." + s + ".start");
            String end = config.getString("timespans." + s + ".end");
            timeSpans.add(new TimeSpan(start, end));

            System.out.println(start);
            System.out.println(end);
        }
    }

    public static boolean canLogIn(Player player) {
        if (config == null) {
            init();
        }

        if (player.hasPermission("letmein.bypass")) {
            return true;
        }

        LocalTime time = LocalTime.now();
        for (TimeSpan ts : timeSpans) {
            if (ts.isInSpan(time)) {
                return false;
            }
        }
        return true;
    }
}
