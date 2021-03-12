package me.fertiz.spawn.commands;

import me.fertiz.spawn.Main;
import me.fertiz.spawn.menus.SpawnMenu;
import me.fertiz.spawn.utils.ChatUtil;
import me.fertiz.spawn.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpawnCommand implements CommandExecutor {

    private final SpawnMenu menu;
    private final int size;

    public SpawnCommand(SpawnMenu menu) {
        this.menu = menu;
        this.size = Main.getInstance().getConfig().getInt("spawn.size");
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String l, String[] args) {
        Player p = (Player) s;

        if (args.length != 0) {

            ChatUtil.sendTitle(p, "BLAD", "&8>> &7Poprawne uzycie: &3/spawn &8<<");

            return false;
        }

        Inventory inv = menu.getInventory();

        World w = Bukkit.getWorlds().get(0);

        List<Entity> players = w.getNearbyEntities(w.getSpawnLocation(), size, 255, size).stream().filter(e -> e instanceof Player).collect(Collectors.toList());

        inv.setItem(13, new ItemBuilder(Material.STAINED_CLAY, 1, (short)13).setTitle("&8&m>>-----)&3&l TELEPORTACJA &8&m(-----<<").addLores(Arrays.asList("", "&8>> &7Graczy na spawnie&8: &3" + players.size(), "", "&8&m>>-----)&3&l TELEPORTACJA &8&m(-----<<")).build());

        p.openInventory(inv);

        return false;
    }
}
