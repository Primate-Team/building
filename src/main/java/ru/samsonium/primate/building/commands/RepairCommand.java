package ru.samsonium.primate.building.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.jetbrains.annotations.NotNull;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.*;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(text("Команда доступна только игрокам", RED));
            return true;
        }

        Player p = (Player) commandSender;
        ItemStack holdingItem = p.getInventory().getItemInMainHand();
        ItemMeta holdingMeta = holdingItem.getItemMeta();

        if (holdingItem.isEmpty()) {
            p.sendMessage(text("Нужно держать инструмент в основной руке", YELLOW));
            return true;
        }

        if (!(holdingMeta instanceof Repairable)) {
            p.sendMessage(text("Этот предмет нельзя починить", YELLOW));
            return true;
        }

        holdingItem.setDurability((short) 0);
        p.sendMessage(text("Предмет восстановлен", GOLD));

        return true;
    }
}
