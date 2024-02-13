package tnt.org.magic.magic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tnt.org.magic.magic.item.fire_wand.fire_wand;
import tnt.org.magic.magic.item.fire_wand.fire_wand_event;
import tnt.org.magic.magic.item.withering_staff.withering_staff;
import tnt.org.magic.magic.item.withering_staff.withering_staff_event;

public final class Magic extends JavaPlugin {

    @Override
    public void onEnable() {


        fire_wand.init();
        Bukkit.getPluginManager().registerEvents(new fire_wand_event(), this);

        withering_staff.init();
        Bukkit.getPluginManager().registerEvents(new withering_staff_event(), this);

    }

    @Override
    public void onDisable() {

    }
}
