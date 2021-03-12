package me.fertiz.spawn.managers;

import me.fertiz.spawn.Main;
import me.fertiz.spawn.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TeleportationManager extends BukkitRunnable {

    private final Player p;
    private final Location from;
    private final Location spawnLocation;
    private long time = Main.getInstance().getConfig().getInt("spawn.time");

    public TeleportationManager(Player p, Location from) {
        this.from = from;
        this.p = p;
        World w = Bukkit.getWorlds().get(0);
        this.spawnLocation = new Location(w, w.getSpawnLocation().getX() + 0.5, w.getSpawnLocation().getY(), w.getSpawnLocation().getZ() + 0.5);
    }

    @Override
    public void run() {

        if (p.getLocation().getBlockX() != from.getBlockX() || p.getLocation().getBlockY() != from.getBlockY() || p.getLocation().getBlockZ() != from.getBlockZ()) {
            ChatUtil.sendActionBar(p, "&8>> &cRuszyles sie! &7Przerwano teleportacje &8<<");
            time = 5;
            this.cancel();
            return;
        }

        if (time > 0) {
            ChatUtil.sendActionBar(p, "&8>> &7Teleportacja nastapi za&8: &3" + time + " s &8<<");
            time--;
        } else {
            p.teleport(spawnLocation);
            ChatUtil.sendActionBar(p, "&8>> &7Pomyslnie przeteleportowano! &8<<");
            time = 5;
            this.cancel();
        }
    }
}
