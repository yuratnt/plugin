package tnt.org.magic.magic.mechanic.mana;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class Mana {


    public static void init() {

    }
    public static void manaBar(Player player) {

        File playerFile = new File("magic/player/" + player.getUniqueId() + ".yml");
        if (!playerFile.exists()) return;

        






        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent());

    }
}
