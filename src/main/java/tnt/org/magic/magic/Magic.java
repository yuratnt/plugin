package tnt.org.magic.magic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tnt.org.magic.magic.item.staff.fire_wand.FireWand;
import tnt.org.magic.magic.item.staff.fire_wand.FireWandEvent;

import tnt.org.magic.magic.item.staff.bat_staff.BatStaff;
import tnt.org.magic.magic.item.staff.bat_staff.BatStaffEvent;
import tnt.org.magic.magic.mechanic.mana.Mana;
import tnt.org.magic.magic.mechanic.mana.ManaEvent;

public final class Magic extends JavaPlugin {


    @Override
    public void onEnable() {

        Mana.init();
        Bukkit.getPluginManager().registerEvents(new ManaEvent(), this);

        FireWand.init();
        Bukkit.getPluginManager().registerEvents(new FireWandEvent(), this);

        BatStaff.init();
        Bukkit.getPluginManager().registerEvents(new BatStaffEvent(), this);

    }

    @Override
    public void onDisable() {

    }
}
