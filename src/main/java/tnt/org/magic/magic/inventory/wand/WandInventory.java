package tnt.org.magic.magic.inventory.wand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.inventory_filler.Filler;
import tnt.org.magic.magic.item.inventory_filler.FillerCreate;
import tnt.org.magic.magic.item.spell.escape.Escape;
import tnt.org.magic.magic.item.spell.fire_ray.FireRay;
import tnt.org.magic.magic.item.spell.fire_ring.FireRing;
import tnt.org.magic.magic.item.spell.frost_storm.FrostStorm;
import tnt.org.magic.magic.item.spell.heal.Heal;
import tnt.org.magic.magic.item.spell.live_steal.LiveSteal;
import tnt.org.magic.magic.item.spell.live_steal.LiveStealCast;
import tnt.org.magic.magic.item.wand.Wand;


public class WandInventory {

    public static ItemStack filler = FillerCreate.createFiller(Filler.BLACK_GLASS_PANE);

    public static void init() {

    }

    public static void createInventory(Wand wand, Player player) {
        if (wand == null) return;

        Inventory inventory = Bukkit.getServer().createInventory(player, 9, wand.getName());

        int slotCount = (9 - wand.getSlotCount()) / 2;

        for (int i = 0; i != slotCount ;i++) {
            inventory.setItem(i, filler);
            inventory.setItem(8 - i, filler);
        }

        switch (wand.getSlotCount()) {
            case 1:
                player.openInventory(inventoryWand(inventory, player, 1, 4));
                break;
            case 3:
                player.openInventory(inventoryWand(inventory, player, 3, 3));
                break;
            case 5:
                player.openInventory(inventoryWand(inventory, player, 5, 2));
                break;

        }
    }

    private static Inventory inventoryWand(Inventory inventory, Player player, int slot, int startFill) {
        ItemMeta wand = player.getInventory().getItem(EquipmentSlot.HAND).getItemMeta();

        for (int i = 0; i != slot;i++ ) {
            switch (wand.getPersistentDataContainer().get(NamespacedKey.fromString("slot_" + i), PersistentDataType.STRING)) {
                case "none":
                    inventory.setItem(startFill, null);
                    break;
                case "fire_ring":
                    inventory.setItem(startFill, FireRing.fireRing);
                    break;
                case "escape":
                    inventory.setItem(startFill, Escape.escape);
                    break;
                case "live_steal":
                    inventory.setItem(startFill, LiveSteal.liveSteal);
                    break;
                case "frost_storm":
                    inventory.setItem(startFill, FrostStorm.frostStorm);
                    break;
                case "heal":
                    inventory.setItem(startFill, Heal.heal);
                    break;
                case "fire_ray":
                    inventory.setItem(startFill, FireRay.fireRay);
                    break;
            }
            startFill++;
        }
        return inventory;
    }










}
