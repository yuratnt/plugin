package tnt.org.magic.magic.item.spell.fire_ring;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

public class FireRingCast {

    public static void fireRingCast(Player player) {
        if (Mana.manaCast(Spell.FIRE_WAND, player)) return;

        Location playerLocation = player.getLocation();
        World playerWorld = player.getWorld();

        int cx = playerLocation.getBlockX();
        int cy = playerLocation.getBlockY();
        int cz = playerLocation.getBlockZ();

        int radius = 3;

        for (int x = cx - radius; x <= cx + radius; x++) {
            for (int z = cz - radius; z <= cz + radius; z++) {
                if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= radius * radius) {
                    Location location = new Location(playerWorld, x, cy, z);

                    location.getWorld().spawnParticle(Particle.FLAME, location, 10);

                    for (Entity entity : location.getWorld().getEntities()) {
                        if (entity instanceof LivingEntity && location.distance(entity.getLocation()) <= radius) {

                            createFire(entity, player);
                        }
                    }
                }
            }
        }
    }
    private static void createFire(Entity entity, Player player) {
        if (entity.equals(player)) return;
        entity.setFireTicks(200);

        if (entity instanceof Mob) {
            ((Mob) entity).setTarget(player);
        }
    }
}
