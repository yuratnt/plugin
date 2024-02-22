package tnt.org.magic.magic.item.wand;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.spell.Spell;

import java.util.ArrayList;
import java.util.List;

public class WandCreate {

    public static ItemStack createWand(Wand wand) {

        ItemStack item = new ItemStack(wand.getMaterial(), 1);
        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();

        lore.add(wand.getLore());

        meta.setDisplayName(wand.getName());
        meta.setLore(lore);

        meta.getPersistentDataContainer().set(NamespacedKey.fromString("tag"), PersistentDataType.STRING, wand.getTag());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("select_slot"), PersistentDataType.STRING, "");

        for (int i = 0; i != wand.getSlotCount(); i++) {
            meta.getPersistentDataContainer().set(NamespacedKey.fromString("slot_" + i), PersistentDataType.STRING, "");
        }

        item.setItemMeta(meta);
        return item;
    }
}
