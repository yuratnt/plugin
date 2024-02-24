package tnt.org.magic.magic.inventory.wand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.inventory_filler.Filler;
import tnt.org.magic.magic.item.inventory_filler.FillerCreate;
import tnt.org.magic.magic.item.wand.Wand;


public class WandInventory {

    public static ItemStack filler = FillerCreate.createFiller(Filler.BLACK_GLASS_PANE);

    public static void init() {

    }

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
    public static void createInventory(Wand wand, Player player) {
        if (wand == null) return;

        Inventory inventory = Bukkit.getServer().createInventory(player, 9, wand.getName());

        int slotCount = (9 - wand.getSlotCount()) / 2;

        for (int i = 0; i != slotCount ;i++) {
            inventory.setItem(i, filler);
            inventory.setItem(8 - i, filler);
        }

        player.openInventory(inventory);
    }










}
