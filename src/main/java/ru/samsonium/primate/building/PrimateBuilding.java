package ru.samsonium.primate.building;

import org.bukkit.plugin.java.JavaPlugin;

public final class PrimateBuilding extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        try {
            Objects.requireNonNull(getCommand("repair")).setExecutor(new RepairCommand());
        } catch (NullPointerException e) {
            getLogger().log(Level.SEVERE, "Cannot register commands");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PrimateBuilding get() {
        return getPlugin(PrimateBuilding.class);
    }
}
