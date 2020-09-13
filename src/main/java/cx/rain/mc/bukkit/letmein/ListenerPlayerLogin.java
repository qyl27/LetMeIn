package cx.rain.mc.bukkit.letmein;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class ListenerPlayerLogin implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (!TimeUtil.canLogIn(event.getPlayer())) {
            event.disallow(Result.KICK_OTHER, LetMeIn.INSTANCE.getConfig().getString("messages.player_kicked"));
        }
    }
}
