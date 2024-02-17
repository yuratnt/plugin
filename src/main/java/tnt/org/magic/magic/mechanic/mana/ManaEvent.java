package tnt.org.magic.magic.mechanic.mana;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import tnt.org.magic.magic.Magic;

import java.awt.peer.LabelPeer;
import java.io.File;
import java.io.IOException;

public class ManaEvent implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        File playerFile = new File("magic/player/" + player.getUniqueId() + ".yml");

        if (!playerFile.exists()) {
            createConfig(playerFile, player);
            manaRegen(player);
        }
        else {
            manaRegen(player);
        }
    }

    private void createConfig(File playerFile, Player player) {
        YamlConfiguration playerConfig = new YamlConfiguration();

        playerConfig.set("name", player.getName());
        playerConfig.set("id", player.getUniqueId().toString());
        playerConfig.set("level", 1);
        playerConfig.set("mana", 100);
        playerConfig.set("manaMax", 100);
        playerConfig.set("manaRegen", 1);
        playerConfig.set("timerId", 0);

        try {
            playerConfig.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @EventHandler
    public void onPlayerQuit (PlayerQuitEvent event) {
        Player playerQuit = event.getPlayer();

        FileConfiguration config = Mana.loadConfig(playerQuit);

        int taskId = config.getInt("timerId");

        Bukkit.getScheduler().cancelTask(taskId);
    }

    public static void manaRegen(Player player) {


        BukkitRunnable timer = new BukkitRunnable() {
            public void run() {
                FileConfiguration config = Mana.loadConfig(player);

                int id = getTaskId();
                config.set("timerId", id);
                Mana.saveConfig(player, config);

                int mana = config.getInt("mana");
                int manaMax = config.getInt("manaMax");
                int manaRegen = config.getInt("manaRegen");
                int regen = mana + manaRegen;

                if (regen >= manaMax) {
                    regen = manaMax;
                }

                config.set("mana", regen);

                Mana.saveConfig(player, config);
                Mana.manaBar(player);
            }
        };
        timer.runTaskTimer(Magic.getPlugin(Magic.class), 0, 20);
    }
}
