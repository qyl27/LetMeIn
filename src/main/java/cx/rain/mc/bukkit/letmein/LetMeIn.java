package cx.rain.mc.bukkit.letmein;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class LetMeIn extends JavaPlugin {
    public static LetMeIn INSTANCE = null;

    private Logger log = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;

        saveDefaultConfig();

        TimeUtil.init();

        Bukkit.getServer().getPluginManager().registerEvents(new ListenerPlayerLogin(), this);

        log.info("Plugin has enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Plugin has disabled.");
    }

    public Logger getLog() {
        return log;
    }
}
