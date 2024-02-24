package tnt.org.magic.magic.item.spell.escape;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.mechanic.mana.Mana;

public class EscapeCast{

    public static void escapeCast(Player player) {
        if (Mana.manaCast(Spell.BAT_STAFF, player)) return;
        spawn(player);
        effect(player);

    }
    private static void spawn(Player player) {
        World world = player.getWorld();
        Location location = player.getLocation();

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        y++;

        Location onePos = new  Location(world, x + 1, y, z);
        Location twoPos = new  Location(world, x - 1, y, z);
        Location threePos = new  Location(world, x, y, z + 1);
        Location fourPos = new  Location(world, x, y, z - 1);

        EntityType bat = EntityType.BAT;

        for (int i = 0; i != 3 ; i++) {
            world.spawnEntity(onePos, bat);
            world.spawnEntity(twoPos, bat);
            world.spawnEntity(threePos, bat);
            world.spawnEntity(fourPos, bat);
        }
    }
    private static void effect(Player player) {
        int time = 600;
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, time, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, time, 1));
    }
}