package me.fertiz.spawn.menus;

import me.fertiz.spawn.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SpawnMenu {

    private final Inventory inv;

    public SpawnMenu() {
        this.inv = Bukkit.createInventory(null, 27, ChatUtil.fixColor("&8>> &3SPAWN &8<<"));
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7));
        }
        int[] blue = {0, 1, 7, 8, 9, 17, 18, 19, 25, 26};

        for (int i : blue) {
            inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3));
        }
    }

    public Inventory getInventory() {
        return inv;
    }
}
