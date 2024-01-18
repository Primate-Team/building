package ru.samsonium.primate.building;

import org.bukkit.plugin.java.JavaPlugin;
import ru.samsonium.primate.building.commands.*;
import ru.samsonium.primate.building.listeners.DamageListener;

import java.util.Objects;
import java.util.logging.Level;

public final class PrimateBuilding extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            Objects.requireNonNull(getCommand("repair")).setExecutor(new RepairCommand());
            Objects.requireNonNull(getCommand("tools")).setExecutor(new ToolsCommand());
            Objects.requireNonNull(getCommand("fight")).setExecutor(new FightCommand());
            Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());
            Objects.requireNonNull(getCommand("god")).setExecutor(new GodCommand());
        } catch (NullPointerException e) {
            getLogger().log(Level.SEVERE, "Cannot register commands");
        }

        getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PrimateBuilding get() {
        return getPlugin(PrimateBuilding.class);
    }
}
