package tnt.org.magic.magic.item.inventory_filler;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class FillerCreate {

    public static ItemStack createFiller(Filler filler) {
        ItemStack item = new ItemStack(filler.getMaterial(), 1);
        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();

        lore.add(filler.getLore());

        meta.setDisplayName(filler.getName());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("tag"), PersistentDataType.STRING, filler.getTag());
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }
}
