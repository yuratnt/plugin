package tnt.org.magic.magic.item.spell.fire_ring;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

public class FireRingEvent implements Listener {

    private Location playerLocation;
    private World playerWorld;
    private Player player;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (!event.getItem().getItemMeta().equals(FireRing.fireRing.getItemMeta())) return;

        playerLocation = event.getPlayer().getLocation();
        playerWorld = event.getPlayer().getWorld();
        player = event.getPlayer();

        if (Mana.manaCast(Spell.FIRE_WAND, player)) return;
        createParticle();
    }
    private void createParticle() {
        int cx = playerLocation.getBlockX();
        int cy = playerLocation.getBlockY();
        int cz = playerLocation.getBlockZ();

        int radius = 3;

        for (int x = cx - radius; x <= cx + radius; x++) {
            for (int z = cz - radius; z <= cz + radius; z++) {
                if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= radius * radius) {
                    Location Location = new Location(playerWorld, x, cy, z);

                    Location.getWorld().spawnParticle(Particle.FLAME, Location, 10);

                    for (Entity entity : Location.getWorld().getEntities()) {
                        if (entity instanceof LivingEntity && Location.distance(entity.getLocation()) <= radius) {

                            createFire(entity);
                        }
                    }
                }
            }
        }
    }
    private void createFire(Entity entity) {
        if (entity.equals(player)) return;
        entity.setFireTicks(200);
    }
}