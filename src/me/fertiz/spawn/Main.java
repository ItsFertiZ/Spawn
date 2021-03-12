package me.fertiz.spawn;

import me.fertiz.spawn.commands.SetspawnCommand;
import me.fertiz.spawn.commands.SpawnCommand;
import me.fertiz.spawn.listeners.InventoryClickListener;
import me.fertiz.spawn.menus.SpawnMenu;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        getCommand("spawn").setExecutor(new SpawnCommand(new SpawnMenu()));
        getCommand("setspawn").setExecutor(new SetspawnCommand());
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
