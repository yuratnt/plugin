package tnt.org.magic.magic.mechanic.mana;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.peer.LabelPeer;
import java.io.File;
import java.io.IOException;

public class ManaEvent implements Listener {
    public Player player;
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        player = event.getPlayer();

        File playerFile = new File("magic/player/"+ player.getUniqueId() + ".yml");
        if (playerFile.exists()) return;

        YamlConfiguration playerConfig = new YamlConfiguration();

        playerConfig.set("name", player.getName());
        playerConfig.set("id", player.getUniqueId());
        playerConfig.set("level", 1);
        playerConfig.set("mana", 100);
        playerConfig.set("manaMax", 100);
        playerConfig.set("manaRegen", 5);

        try {
            playerConfig.save("magic/player/" + player.getUniqueId() + ".yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
