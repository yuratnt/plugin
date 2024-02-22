package tnt.org.magic.magic.inventory.wand;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WandInventoryEvent implements Listener {

    @EventHandler
    public void openInventory (PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (event.getItem() == null) return;
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && player.isSneaking()) {

            WandInventory.wandDeterminant(player, event.getItem().getItemMeta());
        }
    }
}
