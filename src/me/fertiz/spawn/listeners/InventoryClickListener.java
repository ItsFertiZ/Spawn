package me.fertiz.spawn.listeners;

import me.fertiz.spawn.Main;
import me.fertiz.spawn.managers.TeleportationManager;
import me.fertiz.spawn.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private final Main plugin;

    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getClickedInventory() == null || !e.getInventory().getTitle().equalsIgnoreCase(ChatUtil.fixColor("&8>> &3SPAWN &8<<"))) return;

        e.setCancelled(true);

        if (e.getSlot() == 13) {
            
            Player p = (Player) e.getWhoClicked();
            
            p.closeInventory();
            
            new TeleportationManager(p).runTaskTimer(plugin, 0, 20);
        }
    }
}
