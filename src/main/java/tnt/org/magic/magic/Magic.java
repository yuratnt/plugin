package tnt.org.magic.magic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tnt.org.magic.magic.item.spell.fire_ring.FireRing;

import tnt.org.magic.magic.item.spell.escape.Escape;
import tnt.org.magic.magic.inventory.wand.WandInventory;
import tnt.org.magic.magic.inventory.wand.WandInventoryEvent;
import tnt.org.magic.magic.item.spell.frost_storm.FrostStorm;
import tnt.org.magic.magic.item.spell.live_steal.LiveSteal;
import tnt.org.magic.magic.item.wand.MasterWand.MasterWand;
import tnt.org.magic.magic.item.wand.WandSelectSlot;
import tnt.org.magic.magic.item.wand.advanced_wand.AdvancedWand;
import tnt.org.magic.magic.item.wand.begin_wand.BeginWand;
import tnt.org.magic.magic.mechanic.mana.Mana;
import tnt.org.magic.magic.mechanic.mana.ManaEvent;

public final class Magic extends JavaPlugin {

    @Override
    public void onEnable() {

        Mana.init();
        Bukkit.getPluginManager().registerEvents(new ManaEvent(), this);

        //wand
        BeginWand.init();
        AdvancedWand.init();
        MasterWand.init();

        WandInventory.init();
        Bukkit.getPluginManager().registerEvents(new WandSelectSlot(), this);
        Bukkit.getPluginManager().registerEvents(new WandInventoryEvent(), this);

        //spell
        FireRing.init();
        Escape.init();
        LiveSteal.init();
        FrostStorm.init();

    }

    @Override
    public void onDisable() {

    }
}
