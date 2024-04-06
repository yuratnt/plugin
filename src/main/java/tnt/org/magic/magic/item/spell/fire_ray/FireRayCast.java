package tnt.org.magic.magic.item.spell.fire_ray;


import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

import java.util.Objects;


public class FireRayCast {

    public static void fireRay(Player player) {
        if (Mana.manaCast(Spell.FIRE_RAY, player)) return;

        createParticle(player);
    }

    private static void createParticle(Player player) {
        Location playerLocation = player.getEyeLocation();
        Vector direction = playerLocation.getDirection();
        Location targetLocation = playerLocation.clone();


        for (int i = 0; i <= 10; i++) {
            targetLocation.add(direction);

            detectEntity(targetLocation, player);

            playerLocation.getWorld().spawnParticle(
                    Particle.FLAME,
                    targetLocation,
                    0
            );

            if (i <= 3) {
                redStoneParticle(Color.fromRGB(250, 138, 32), playerLocation, targetLocation);
            }
            else if (i <= 5) {
                redStoneParticle(Color.fromRGB(240, 111, 19), playerLocation, targetLocation);
            }
            else if (i <= 7) {
                redStoneParticle(Color.fromRGB(196, 58, 16), playerLocation, targetLocation);
            }
            else {
                redStoneParticle(Color.fromRGB(191, 27, 46), playerLocation, targetLocation);
            }
        }
    }

    private static void redStoneParticle(Color color, Location playerLocation, Location targetLocation) {
        playerLocation.getWorld().spawnParticle(
                Particle.REDSTONE,
                targetLocation,
                10, new Particle.DustOptions(color, 1)
        );
    }

    private static void detectEntity(Location targetLocation, Player player) {
        for (Entity entity : Objects.requireNonNull(targetLocation.getWorld()).getEntities()) {
            if (entity instanceof LivingEntity) {
                if (entity instanceof Mob) {
                    ((Mob) entity).setTarget(player);
                }

                damage((LivingEntity) entity);
            }
        }
    }

    private static void damage(LivingEntity entity) {
        entity.setFireTicks(50);
        entity.damage(1);
    }
}

