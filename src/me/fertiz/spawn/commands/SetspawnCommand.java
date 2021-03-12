package me.fertiz.spawn.commands;

import me.fertiz.spawn.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetspawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command command, String l, String[] args) {

        Player p = (Player) s;

        if (args.length != 0) {
            ChatUtil.sendTitle(p, "BLAD", "&8>> &7Poprawne uzycie&8: &3/setspawn &8<<");
            return false;
        }

        int x = p.getLocation().getBlockX();
        int y = p.getLocation().getBlockY();
        int z = p.getLocation().getBlockZ();

        p.getWorld().setSpawnLocation(x, y, z);

        ChatUtil.sendTitle(p, "SUKCES", String.format("&8>> &7Ustawiles spawn na&8: &3%d X, %d Y, %d Z", x, y ,z));
        return false;
    }
}
