package ru.samsonium.primate.building.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import ru.samsonium.primate.building.PrimateBuilding;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.*;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(text("Команда доступна только игрокам", RED));
            return true;
        }

        Player p = (Player) commandSender;
        if (p.hasMetadata("god-mode")) p.removeMetadata("god-mode", PrimateBuilding.get());
        else p.setMetadata("god-mode", new FixedMetadataValue(PrimateBuilding.get(), "yiis"));

        boolean nowValue = p.hasMetadata("god-mode");
        p.sendMessage(text().append(text("Режим бога ", WHITE),
                text(nowValue ? "включён" : "выключен", GOLD)));

        return true;
    }
}
