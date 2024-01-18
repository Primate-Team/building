package ru.samsonium.primate.building.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.*;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(text("Команда доступна только игрокам", RED));
            return true;
        }

        Player p = (Player) commandSender;

        boolean nowFlightValue = !p.getAllowFlight();
        p.setAllowFlight(nowFlightValue);

        p.sendMessage(text().append(text("Режим полёта ", WHITE),
                text(nowFlightValue ? "включён" : "выключен", GOLD)));

        return true;
    }
}
