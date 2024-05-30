package levithean.leviplugin;

import levithean.leviplugin.commands.CheatGUICommand;
import levithean.leviplugin.listeners.InventoryListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getLogger().info("leviPlugin enabled");
        getCommand("cheatgui").setExecutor(new CheatGUICommand());
        getServer().getPluginManager().registerEvents(new InventoryListeners(), this);
    }

    @Override
    public void onDisable() {

        getServer().getLogger().info("leviPlugin disabled");

    }
}
