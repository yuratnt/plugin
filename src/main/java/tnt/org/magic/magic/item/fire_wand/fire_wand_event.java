package tnt.org.magic.magic.item.fire_wand;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class fire_wand_event implements Listener {

    private Location PlayerLocation;
    private World PlayerWorld;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().getItemMeta().equals(fire_wand.fire_wand.getItemMeta())) {

                PlayerLocation = event.getPlayer().getLocation();
                PlayerWorld = event.getPlayer().getWorld();

                if (event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.BLAZE_POWDER)) {
                    int amount = event.getPlayer().getInventory().getItemInOffHand().getAmount();

                    event.getPlayer().getInventory().getItemInOffHand().setAmount(amount - 1);

                    createFire();
                }

            }
        }
    }
    private void createFire() {
        int cx = PlayerLocation.getBlockX();
        int cy = PlayerLocation.getBlockY();
        int cz = PlayerLocation.getBlockZ();

        int radius = 3;

        for (int x = cx - radius; x <= cx + radius; x++) {
            for (int z = cz - radius; z <= cz + radius; z++) {
                if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= radius * radius) {
                    Location Location = new Location(PlayerWorld, x, cy, z);

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
