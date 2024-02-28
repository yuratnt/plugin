package tnt.org.magic.magic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tnt.org.magic.magic.item.spell.fire_ring.FireRing;
import tnt.org.magic.magic.item.spell.fire_ring.FireRingCast;

import tnt.org.magic.magic.item.spell.escape.Escape;
import tnt.org.magic.magic.inventory.wand.WandInventory;
import tnt.org.magic.magic.inventory.wand.WandInventoryEvent;
import tnt.org.magic.magic.item.wand.MasterWand.MasterWand;
import tnt.org.magic.magic.item.wand.MasterWand.MasterWandEvent;
import tnt.org.magic.magic.item.wand.advanced_wand.AdvancedWand;
import tnt.org.magic.magic.item.wand.advanced_wand.AdvancedWandEvent;
import tnt.org.magic.magic.item.wand.begin_wand.BeginWand;
import tnt.org.magic.magic.item.wand.begin_wand.BeginWandEvent;
import tnt.org.magic.magic.mechanic.mana.Mana;
import tnt.org.magic.magic.mechanic.mana.ManaEvent;

public final class Magic extends JavaPlugin {


    @Override
    public void onEnable() {

        Mana.init();
        Bukkit.getPluginManager().registerEvents(new ManaEvent(), this);

        Bukkit.getPluginManager().registerEvents(new BeginWandEvent(), this);

        Bukkit.getPluginManager().registerEvents(new AdvancedWandEvent(), this);

        Bukkit.getPluginManager().registerEvents(new MasterWandEvent(), this);

        WandInventory.init();
        Bukkit.getPluginManager().registerEvents(new WandInventoryEvent(), this);

        BeginWand.init();

        AdvancedWand.init();

        MasterWand.init();

        FireRing.init();

        Escape.init();

    }

    @Override
    public void onDisable() {

    }
}
