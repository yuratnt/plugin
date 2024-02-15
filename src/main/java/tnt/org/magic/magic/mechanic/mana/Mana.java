package tnt.org.magic.magic.mechanic.mana;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Mana {


    public static void init() {

    }
    public static void manaBar(Player player) {
        String filePath = "magic/player/" + player.getUniqueId() + ".yml";

        File playerFile = new File(filePath);
        if (!playerFile.exists()) return;

        FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);

        String mana = config.getString("mana");

        System.out.println(mana);
    }
}
