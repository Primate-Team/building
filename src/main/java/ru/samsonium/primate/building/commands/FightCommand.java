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

public class FightCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(text("Команда доступна только игрокам", RED));
            return true;
        }

        Player p = (Player) sender;
        Inventory inv = Bukkit.createInventory(p, 9 * 2, text("Оружие и броня", GOLD));

        inv.setItem(0, getArmor(Material.NETHERITE_HELMET));
        inv.setItem(1, getArmor(Material.NETHERITE_CHESTPLATE));
        inv.setItem(2, getArmor(Material.NETHERITE_LEGGINGS));
        inv.setItem(3, getArmor(Material.NETHERITE_BOOTS));

        inv.setItem(9, getWeapon(Material.NETHERITE_SWORD));
        inv.setItem(10, getWeapon(Material.NETHERITE_AXE));

        p.openInventory(inv);

        return true;
    }

    /**
     * Create armor ItemStack with enchantments
     * @param material Armor
     * @return ItemStack
     */
    private ItemStack getArmor(Material material) {
        ItemStack armor = new ItemStack(material, 1);
        ItemMeta meta = armor.getItemMeta();

        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
        meta.addEnchant(Enchantment.BINDING_CURSE, 10, true);
        meta.addEnchant(Enchantment.THORNS, 10, true);

        armor.setItemMeta(meta);
        return armor;
    }

    /**
     * Get enchanted sword
     * @return ItemStack
     */
    private ItemStack getWeapon(Material material) {
        ItemStack sword = new ItemStack(material, 1);
        ItemMeta meta = sword.getItemMeta();

        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 10, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 10, true);

        sword.setItemMeta(meta);
        return sword;
    }
}
