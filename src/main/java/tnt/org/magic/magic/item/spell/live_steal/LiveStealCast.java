package tnt.org.magic.magic.item.spell.live_steal;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

import java.util.List;


public class LiveStealCast {

    public static void liveStealCast(Player player) {
        if (Mana.manaCast(Spell.LIVE_STEAL, player)) return;
        Vector playerDirection  = player.getLocation().getDirection();
        Location targetLocation = player.getLocation().add(playerDirection.multiply(5));
        List<Entity> nearbyEntities = player.getNearbyEntities(5, 5, 5);

        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity) {
                if (entity.getLocation().distance(targetLocation) <= 5) {
                    liveSteal((LivingEntity) entity, player);
                    createParticle((LivingEntity) entity, player);

                }
            }
        }
    }

    private static void liveSteal(LivingEntity entity, Player player) {
        int time = 20;
        entity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, time, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, time, 2));

        if (entity instanceof Mob) {
            ((Mob) entity).setTarget(player);
        }
    }

    private static void createParticle(LivingEntity entity, Player player) {
        Location playerLocation = player.getLocation();
        Location entityLocation = entity.getLocation();

        for (int i = 0; i != 2 ; i++){
            entityLocation.getWorld().spawnParticle(Particle.SMOKE_LARGE, entityLocation.getBlockX(), entityLocation.getBlockY() + i, entityLocation.getBlockZ(), 25);
        }

        playerLocation.getWorld().spawnParticle(Particle.HEART, playerLocation.getBlockX(), playerLocation.getBlockY() + 2, playerLocation.getBlockZ(), 1);
    }
}