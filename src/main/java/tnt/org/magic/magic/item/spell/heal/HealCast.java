package tnt.org.magic.magic.item.spell.heal;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

import java.util.Random;

public class HealCast {

    public static void healCast(Player player) {
        double maxHeath = player.getHealthScale();
        double heath = player.getHealth();

        if (maxHeath == heath) return;
        if (Mana.manaCast(Spell.HEAL, player)) return;

        player.setHealth(Math.min(heath + 10, maxHeath));

        spawnParticle(player.getLocation());
    }

    private static void spawnParticle(Location location) {

        for (int i = 0; i != 9; i++) {
            for (int y = 0; y != 2; y++) {
                location.getWorld().spawnParticle(
                        Particle.VILLAGER_HAPPY,
                        location.getBlockX() + random(),
                        location.getBlockY() + y + random(),
                        location.getBlockZ() + random(),
                        0
                );
            }

        }
    }

    private static double random() {
        Random random = new Random();
        return 0.1 + (0.999 - 0.1) * random.nextDouble();
    }
}
