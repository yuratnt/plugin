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
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import tnt.org.magic.magic.Magic;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Mana {

    public static void init() {

    }
    public static FileConfiguration loadConfig(Player player) {
        String filePath = "magic/player/" + player.getUniqueId() + ".yml";

        File playerFile = new File(filePath);
        if (!playerFile.exists()) return null;

        return YamlConfiguration.loadConfiguration(playerFile);
    }

    public static void saveConfig(Player player, FileConfiguration config) {
        try {
            config.save("magic/player/"  + player.getUniqueId() + ".yml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void manaBar(Player player) {
        FileConfiguration config = loadConfig(player);
        if (config == null) return;

        String mana = config.getString("mana");
        String manaMax = config.getString("manaMax");

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§9" +mana + "/" + manaMax));
    }
    public static void manaRegen(Player player) {
        FileConfiguration config = loadConfig(player);

        int mana = config.getInt("mana");
        int manaMax = config.getInt("manaMax");
        int manaRegen = config.getInt("manaRegen");

        int regen = mana + manaRegen;

        config.set("mana", regen);
        saveConfig(player, config);

        if (mana <= manaMax) return;
        config.set("mana", manaMax);


    }
}
