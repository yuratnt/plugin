package tnt.org.magic.magic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tnt.org.magic.magic.item.fire_wand.FireWand;
import tnt.org.magic.magic.item.fire_wand.FireWandEvent;

import tnt.org.magic.magic.item.withering_staff.WitheringStaff;
import tnt.org.magic.magic.item.withering_staff.WitheringStaffEvent;

public final class Magic extends JavaPlugin {

    @Override
    public void onEnable() {


        FireWand.init();
        Bukkit.getPluginManager().registerEvents(new FireWandEvent(), this);

        WitheringStaff.init();
        Bukkit.getPluginManager().registerEvents(new WitheringStaffEvent(), this);

    }

    @Override
    public void onDisable() {

    }
}
