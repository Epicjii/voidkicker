package plugin.voidkicker;

import org.bukkit.plugin.java.JavaPlugin;

public final class VoidKicker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Kicker(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
