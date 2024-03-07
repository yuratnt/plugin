package tnt.org.magic.magic.item.wand;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class WandDeterminant {

    public static Wand wandDeterminant(ItemMeta meta) {
        if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING) == null) return null;
        String tag = meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING);
        Wand wand = null;

        if (Wand.BEGIN_WAND.getTag().equals(tag)) {
            wand = Wand.BEGIN_WAND;
        }
        else if (Wand.ADVANCED_WAND.getTag().equals(tag)) {
            wand = Wand.ADVANCED_WAND;
        }
        else if (Wand.MASTER_WAND.getTag().equals(tag)) {
            wand = Wand.MASTER_WAND;
        }
        return wand;

    }
}
