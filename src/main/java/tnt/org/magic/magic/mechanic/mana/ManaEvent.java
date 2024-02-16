package tnt.org.magic.magic.mechanic.mana;

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

    private BukkitRunnable timer;

    public Player player;
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        player = event.getPlayer();
        int nameConfig = 0;

        File playerFile = new File("magic/player/" + nameConfig + ".yml");

        for (int i = 0;playerFile.exists(); i++) {
            Mana.loadConfig(player);
        }

        if (!playerFile.exists()) {
            createConfig(playerFile);
            manaTimer(player);

        }
        else {
            manaTimer(player);
        }
    }

    private void createConfig(File playerFile) {
        YamlConfiguration playerConfig = new YamlConfiguration();

        playerConfig.set("name", player.getName());
        playerConfig.set("id", player.getUniqueId().toString());
        playerConfig.set("level", 1);
        playerConfig.set("mana", 100);
        playerConfig.set("manaMax", 100);
        playerConfig.set("manaRegen", 5);
        playerConfig.set("timerId", 0);

        try {
            playerConfig.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @EventHandler
    public void onPlayerQuit (PlayerQuitEvent event) {
        System.out.println(event.getPlayer().getName() + " leave server");

        Player playerQuit = event.getPlayer();

        FileConfiguration config = Mana.loadConfig(playerQuit);

        assert config != null;
        int timerId = config.getInt("timerId");

        if (timer.getTaskId() != timerId) return;
        timer.cancel();
    }

    public void manaTimer(Player player) {
        FileConfiguration config = Mana.loadConfig(player);

        timer = new BukkitRunnable() {
            public void run() {
                int id = getTaskId();
                config.set("timerId", id);
                Mana.saveConfig(player, config);

                Mana.manaRegen(player);

            }
        };
        timer.runTaskTimer(Magic.getPlugin(Magic.class), 0, 100);
    }
}
