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

        File playerFile = new File("magic/player/" + player.getUniqueId() + ".yml");

        if (!playerFile.exists()) {
            createConfig(playerFile);
            manaRegen(player);
        }
        else {
            manaRegen(player);
        }
    }

    private void createConfig(File playerFile) {
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
        System.out.println(event.getPlayer().getName() + " leave server");

        Player playerQuit = event.getPlayer();

        FileConfiguration config = Mana.loadConfig(playerQuit);

        assert config != null;
        int timerId = config.getInt("timerId");

        if (timer.getTaskId() != timerId) return;
        timer.cancel();
    }

    public void manaRegen(Player player) {
        FileConfiguration config = Mana.loadConfig(player);

        timer = new BukkitRunnable() {
            public void run() {
                int id = getTaskId();
                config.set("timerId", id);

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
