package tnt.org.magic.magic.mechanic.mana;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import tnt.org.magic.magic.item.spell.Spell;

import java.io.File;
import java.io.IOException;

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

    public static boolean manaCast(Spell staff, Player player) {
        FileConfiguration config = loadConfig(player);

        int taskId = config.getInt("timerId");

        Bukkit.getScheduler().cancelTask(taskId);

        int mana = config.getInt("mana");
        int manaCast = staff.getMana();

        if (mana < manaCast) {
            ManaEvent.manaRegen(player);
            return true;
        }
        else {
            int cast = mana - manaCast;

            config.set("mana", cast);
            saveConfig(player, config);

            ManaEvent.manaRegen(player);
            return false;
        }
    }
}
