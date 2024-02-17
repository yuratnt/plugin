package tnt.org.magic.magic.item;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.staff.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemCreate {

    public static ItemStack createStaff(Staff staff)
    {

        ItemStack item = new ItemStack(staff.getMaterial(), 1);
        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();

        lore.add(staff.getLore());
        lore.add("§9Потребляет " + staff.getMana() + " маны");

        meta.setDisplayName(staff.getName());
        meta.setLore(lore);

        meta.getPersistentDataContainer().set(NamespacedKey.fromString("staff_name"), PersistentDataType.STRING, staff.getTag());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("mana_usage"), PersistentDataType.INTEGER, staff.getMana());

        item.setItemMeta(meta);

        return item;
    }
}
