package tnt.org.magic.magic.inventory.wand;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.inventory_filler.Filler;
import tnt.org.magic.magic.item.wand.Wand;
import tnt.org.magic.magic.item.wand.WandDeterminant;

public class WandInventoryEvent implements Listener {

    @EventHandler
    public void openInventory (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (event.getItem() == null) return;

        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && player.isSneaking()) {
            WandInventory.createInventory(WandDeterminant.wandDeterminant(event.getItem().getItemMeta()), player);
        }
    }

    @EventHandler
    public void fillerClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;

        String wandName = event.getView().getTitle();

        if (wandName == null) return;

        ItemMeta clickedItemMeta = event.getCurrentItem().getItemMeta();
        Wand wand = null;

        if (wandName.equals(Wand.BEGIN_WAND.getName())) {
            wandName = Wand.BEGIN_WAND.getName();
        }
        else if (wandName.equals(Wand.ADVANCED_WAND.getName())) {
            wandName = Wand.ADVANCED_WAND.getName();
        }
        else if (wandName.equals(Wand.MASTER_WAND.getName())) {
            wandName = Wand.MASTER_WAND.getName();
        }

        if (WandInventory.filler.getItemMeta().equals(clickedItemMeta)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void foreignObjectClick(InventoryClickEvent event) {
        if (event.getCursor() == null) return;
        if (event.getCurrentItem() == null) return;

        String inventoryName = event.getView().getTitle();

        if (inventoryName == null) return;

        ItemMeta itemMeta = event.getCurrentItem().getItemMeta();

        if (inventoryName.equals(Wand.BEGIN_WAND.getName()) || inventoryName.equals(Wand.ADVANCED_WAND.getName()) || inventoryName.equals(Wand.MASTER_WAND.getName())) {
            if (itemMeta.getPersistentDataContainer().get(NamespacedKey.fromString("spell"), PersistentDataType.STRING) == null) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void closeWand(InventoryCloseEvent event) {
        String wandName = event.getView().getTitle();
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();

        if (wandName.equals(Wand.BEGIN_WAND.getName())) {
            containerWand(inventory, player, Wand.BEGIN_WAND.getSlotCount(), 4);
        }
        else if (wandName.equals(Wand.ADVANCED_WAND.getName())) {
            containerWand(inventory, player, Wand.ADVANCED_WAND.getSlotCount(), 3);
        }
        else if (wandName.equals(Wand.MASTER_WAND.getName())) {
            containerWand(inventory, player, Wand.MASTER_WAND.getSlotCount(), 2);
        }
    }

    private void containerWand(Inventory inventory, Player player, int slot, int startFill) {
        for (int i = 0; i != slot; i++) {
            if (inventory.getItem(startFill) == null) {
                ItemMeta wand = player.getInventory().getItem(EquipmentSlot.HAND).getItemMeta();
                wand.getPersistentDataContainer().set(NamespacedKey.fromString("slot_" + i), PersistentDataType.STRING, "none");

                player.getInventory().getItem(EquipmentSlot.HAND).setItemMeta(wand);
            }
            else {
                if (inventory.getItem(startFill).getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING) == null) return;

                String spell = inventory.getItem(startFill).getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING);
                ItemMeta wand = player.getInventory().getItem(EquipmentSlot.HAND).getItemMeta();
                wand.getPersistentDataContainer().set(NamespacedKey.fromString("slot_" + i), PersistentDataType.STRING, spell);

                player.getInventory().getItem(EquipmentSlot.HAND).setItemMeta(wand);
            }
            startFill++;
        }
    }
}
