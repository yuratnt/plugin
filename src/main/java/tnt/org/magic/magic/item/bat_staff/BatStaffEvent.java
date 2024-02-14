package tnt.org.magic.magic.item.bat_staff;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.swing.border.TitledBorder;

public class BatStaffEvent implements Listener {

    private Location location;
    private World world;
    private Player player;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().getItemMeta().equals(BatStaff.withering_staff.getItemMeta())) {

                location = event.getPlayer().getLocation();
                world = event.getPlayer().getWorld();
                player = event.getPlayer();

                spawn();
                effect();
            }
        }
    }
    private void spawn() {

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
    private void effect() {
        int time = 600;
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, time, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, time, 1));

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("test"));

    }
}