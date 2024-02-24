package tnt.org.magic.magic.inventory.wand;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.inventory_filler.Filler;
import tnt.org.magic.magic.item.wand.Wand;

public class WandInventoryEvent implements Listener {

    @EventHandler
    public void openInventory (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (event.getItem() == null) return;

        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && player.isSneaking()) {

            WandInventory.createInventory(WandInventory.wandDeterminant(event.getItem().getItemMeta()), player);
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
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
    public void closeWand(InventoryCloseEvent event) {
        String wandName = event.getView().getTitle();
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();

        if (wandName.equals(Wand.BEGIN_WAND.getName())) {
            beginWand(inventory, player);
        }
        else if (wandName.equals(Wand.ADVANCED_WAND.getName())) {
            advancedWand(inventory, player);
        }
        else if (wandName.equals(Wand.MASTER_WAND.getName())) {
            masterWand(inventory, player);
        }
    }

    private void beginWand(Inventory inventory, Player player) {
        if (inventory.getItem(4) == null) return;

    }

    private void advancedWand(Inventory inventory, Player player) {

    }

    private void masterWand(Inventory inventory, Player player) {

    }

}
