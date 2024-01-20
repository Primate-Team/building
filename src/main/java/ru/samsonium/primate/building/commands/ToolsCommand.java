package ru.samsonium.primate.building.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GOLD;
import static net.kyori.adventure.text.format.NamedTextColor.RED;

public class ToolsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(text("Команда доступна только игрокам", RED));
            return true;
        }

        Player p = (Player) commandSender;
        Inventory inv = Bukkit.createInventory(p, 9, text("Доступные предметы", GOLD));

        inv.setItem(0, getTool(Material.NETHERITE_PICKAXE));
        inv.setItem(1, getTool(Material.NETHERITE_SHOVEL));
        inv.setItem(2, getTool(Material.NETHERITE_AXE));

        p.openInventory(inv);

        return true;
    }

    /**
     * Creates tool
     * @param material Tool
     * @return ItemStack
     */
    private ItemStack getTool(Material material) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        meta.addEnchant(Enchantment.WATER_WORKER, 5, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 5, true);

        item.setItemMeta(meta);
        return item;
    }
}
