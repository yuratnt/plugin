package tnt.org.magic.magic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tnt.org.magic.magic.item.spell.fire_ring.FireRing;
import tnt.org.magic.magic.item.spell.fire_ring.FireRingEvent;

import tnt.org.magic.magic.item.spell.escape.Escape;
import tnt.org.magic.magic.item.spell.escape.EscapeEvent;
import tnt.org.magic.magic.item.wand.MasterWand.MasterWand;
import tnt.org.magic.magic.item.wand.advanced_wand.AdvancedWand;
import tnt.org.magic.magic.item.wand.begin_wand.BeginWand;
import tnt.org.magic.magic.mechanic.mana.Mana;
import tnt.org.magic.magic.mechanic.mana.ManaEvent;

public final class Magic extends JavaPlugin {


    @Override
    public void onEnable() {

        Mana.init();
        Bukkit.getPluginManager().registerEvents(new ManaEvent(), this);

        BeginWand.init();

        AdvancedWand.init();

        MasterWand.init();

        FireRing.init();
        Bukkit.getPluginManager().registerEvents(new FireRingEvent(), this);

        Escape.init();
        Bukkit.getPluginManager().registerEvents(new EscapeEvent(), this);

    }

    @Override
    public void onDisable() {

    }
}
