package tnt.org.magic.magic.item.wand.begin_wand;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.spell.escape.EscapeCast;
import tnt.org.magic.magic.item.spell.fire_ring.FireRingCast;
import tnt.org.magic.magic.item.wand.Wand;

public class BeginWandEvent implements Listener {

    @EventHandler
    public void spellCast(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() == null) return;

        ItemMeta meta = event.getItem().getItemMeta();
        if (meta == null) return;
        if (meta.getPersistentDataContainer() == null) return;


        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING) == null) return;
            if (!meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING).equals(Wand.BEGIN_WAND.getTag())) return;

            String spell = meta.getPersistentDataContainer().get(NamespacedKey.fromString("select_slot"), PersistentDataType.STRING);

            if (spell.equals("none")) return;

            switch (spell) {
                case "fire_ring":
                    FireRingCast.fireRingCast(player);
                    break;
                case "escape":
                    EscapeCast.escapeCast(player);
                    break;
            }
        }
    }
}
