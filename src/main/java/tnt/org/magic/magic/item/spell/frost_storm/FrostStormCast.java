package tnt.org.magic.magic.item.spell.frost_storm;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import tnt.org.magic.magic.Magic;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

import java.util.Random;

public class FrostStormCast {

    public static void frostStormCast(Player player) {
        if (Mana.manaCast(Spell.FROST_STORM, player)) return;

        Location playerLocation = player.getLocation();
        World playerWorld = player.getWorld();

        int cx = playerLocation.getBlockX();
        int cy = playerLocation.getBlockY();
        int cz = playerLocation.getBlockZ();

        int radius = 5;

        for (int i = 0; i != 3; i++ ) {

            for (int x = cx - radius; x <= cx + radius; x++) {
                for (int z = cz - radius; z <= cz + radius; z++) {
                    if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= radius * radius) {
                        Location location = new Location(playerWorld, x, cy, z);

                        spawnParticle(location);

                        for (Entity entity : location.getWorld().getEntities()) {
                            if (entity instanceof LivingEntity && location.distance(entity.getLocation()) <= radius) {
                                effect((LivingEntity) entity, player);
                            }
                        }
                    }
                }
            }
            cy++;
        }
    }

    private static void effect(LivingEntity entity, Player player) {
        if (entity.equals(player)) return;
        Location location = entity.getLocation();
        BukkitRunnable effect = new BukkitRunnable() {
            private int count = 0;
            public void run() {
                if (count ==9) {
                    this.cancel();
                }
                else {
                    entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 2));
                    entity.damage(1);

                    location.getWorld().spawnParticle(
                            Particle.SNOWFLAKE,
                            location.getBlockX() + random(),
                            location.getBlockY() + 2 + random() ,
                            location.getBlockZ() + random(),
                            0);

                    count++;
                }
            }
        };
        effect.runTaskTimer(Magic.getPlugin(Magic.class), 0, 10);
    }

    private static void spawnParticle(Location location) {
        BukkitRunnable spawnParticle = new BukkitRunnable() {
            private int count = 0;
            public void run() {

                if (count == 9) {
                    this.cancel();
                } else {
                count++;
                    for (int i = 0; i != 2; i++) {
                        location.getWorld().spawnParticle(
                                Particle.SNOWFLAKE,
                                location.getBlockX() + random(),
                                location.getBlockY() + random(),
                                location.getBlockZ() + random(),
                                0
                        );
                    }
                }
            }
        };
        spawnParticle.runTaskTimer(Magic.getPlugin(Magic.class), 0, 10);
    }

    private static double random() {
        Random random = new Random();
        return 0.1 + (0.999 - 0.1) * random.nextDouble();
    }
}
