package tnt.org.magic.magic.item.spell;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class SpellCreate {

    public static ItemStack createSpell(Spell spell)
    {

        ItemStack item = new ItemStack(spell.getMaterial(), 1);
        item.setAmount(1);

        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();

        lore.add(spell.getLore());
        lore.add("§9Потребляет " + spell.getMana() + " маны");

        meta.setDisplayName(spell.getName());
        meta.setLore(lore);

        meta.getPersistentDataContainer().set(NamespacedKey.fromString("tag"), PersistentDataType.STRING, spell.getTag());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("mana_usage"), PersistentDataType.INTEGER, spell.getMana());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("spell"), PersistentDataType.STRING, "spell");

        item.setItemMeta(meta);

        return item;
    }
}
