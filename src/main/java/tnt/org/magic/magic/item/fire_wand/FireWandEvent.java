package tnt.org.magic.magic.item.fire_wand;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireWandEvent implements Listener {

    private Location playerLocation;
    private World playerWorld;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (!event.getItem().getItemMeta().equals(FireWand.fire_wand.getItemMeta())) return;
        playerLocation = event.getPlayer().getLocation();
        playerWorld = event.getPlayer().getWorld();

        if (!event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.BLAZE_POWDER)) return;

        int amount = event.getPlayer().getInventory().getItemInOffHand().getAmount();
        event.getPlayer().getInventory().getItemInOffHand().setAmount(amount - 1);
        createFire();

        }
    private void createFire() {
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

                            entity.setFireTicks(200);
                        }
                    }
                }
            }
        }
    }
}
