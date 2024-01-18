package ru.samsonium.primate.building.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;

        Player p = (Player) e.getEntity();
        if (!p.hasMetadata("god-mode")) return;

        e.setCancelled(true);
        p.setFireTicks(0);

        if (e.getCause() == EntityDamageEvent.DamageCause.VOID)
            p.performCommand("spawn");
    }
}
