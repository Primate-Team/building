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
import static net.kyori.adventure.text.format.NamedTextColor.RED;

public class ToolsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(text("Команда доступна только игрокам", RED));
            return true;
        }

        Player p = (Player) commandSender;
        Inventory availItems = Bukkit.createInventory(p, 9, "Доступные предметы");

        // Super Pickaxe
        ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        pickaxeMeta.setUnbreakable(true);
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        pickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        pickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 5, true);
        pickaxeMeta.addEnchant(Enchantment.WATER_WORKER, 5, true);
        pickaxe.setItemMeta(pickaxeMeta);

        // Super Shovel
        ItemStack shovel = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta shovelMeta = pickaxe.getItemMeta();
        shovelMeta.setUnbreakable(true);
        shovelMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        shovelMeta.addEnchant(Enchantment.SILK_TOUCH, 5, true);
        shovelMeta.addEnchant(Enchantment.WATER_WORKER, 5, true);
        shovel.setItemMeta(shovelMeta);

        // Super Axe
        ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta axeMeta = pickaxe.getItemMeta();
        axeMeta.setUnbreakable(true);
        axeMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        axeMeta.addEnchant(Enchantment.WATER_WORKER, 5, true);
        axe.setItemMeta(axeMeta);

        availItems.setItem(0, pickaxe);
        availItems.setItem(1, shovel);
        availItems.setItem(2, axe);

        p.openInventory(availItems);

        return true;
    }
}
