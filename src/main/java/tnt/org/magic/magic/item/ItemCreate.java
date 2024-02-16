package tnt.org.magic.magic.item;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.staff.Staff;

import java.util.List;

public class ItemCreate {

    public static ItemStack createStaff(
            int manaUsage,
            String name,
            List<String> lore,
            Material material,
            String tag
    )
    {

        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("staff_name"), PersistentDataType.STRING, tag);
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("mana_usage"), PersistentDataType.INTEGER, manaUsage);

        item.setItemMeta(meta);

        return item;
    }
}
