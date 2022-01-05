package plugin.voidkicker;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kicker implements Listener {

    @EventHandler
    public void playerKicker(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        if (player.getWorld().getEnvironment() != World.Environment.THE_END) {
            return;
        }
        if (player.getLocation().getBlockY() >= 0) {
            return;
        }

        World overworld = null;

        for (World world : Bukkit.getServer().getWorlds()) {
            if (world.getEnvironment() == World.Environment.NORMAL) {
                overworld = world;
                break;
            }
        }
        if (overworld == null) {
            return;
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 50, 10000));
        player.teleport(overworld.getSpawnLocation());
        player.kick(Component.text("Traveling to New World!"));
    }
}
