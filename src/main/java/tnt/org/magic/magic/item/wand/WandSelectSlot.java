package tnt.org.magic.magic.item.wand;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tnt.org.magic.magic.item.spell.escape.EscapeCast;
import tnt.org.magic.magic.item.spell.fire_ring.FireRingCast;

import java.awt.peer.LabelPeer;

public class WandSelectSlot implements Listener {

    @EventHandler
    public void selectSlot(PlayerInteractEvent event) {
        if (event.getItem() == null) return;

        ItemStack item = event.getItem();
        ItemMeta meta = event.getItem().getItemMeta();

        if (meta == null) return;
        if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("wand"), PersistentDataType.STRING) == null) return;
        if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING) == null) return;

        Wand wand = WandDeterminant.wandDeterminant(meta);

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            selectSlot(wand.getSlotCount(), meta, item);
        }
    }

    @EventHandler
    public void spellCast(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() == null) return;

        ItemMeta meta = event.getItem().getItemMeta();
        if (meta == null) return;

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("wand"), PersistentDataType.STRING) == null) return;
            if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING) == null) return;

            Wand wand = WandDeterminant.wandDeterminant(meta);

            if (!meta.getPersistentDataContainer().get(NamespacedKey.fromString("tag"), PersistentDataType.STRING).equals(wand.getTag())) return;

            String spell = meta.getPersistentDataContainer().get(NamespacedKey.fromString("slot_" +
                    meta.getPersistentDataContainer().get(NamespacedKey.fromString("select_slot"), PersistentDataType.INTEGER)), PersistentDataType.STRING);

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

    public static void selectSlot(int slotCount, ItemMeta meta, ItemStack item) {
        slotCount--;

        if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("select_slot"), PersistentDataType.INTEGER) == null) return;

        if (meta.getPersistentDataContainer().get(NamespacedKey.fromString("select_slot"), PersistentDataType.INTEGER) == slotCount){

            meta.getPersistentDataContainer().set(NamespacedKey.fromString("select_slot"), PersistentDataType.INTEGER, 0);

            item.setItemMeta(meta);
        }
        else {
            int slot = meta.getPersistentDataContainer().get(NamespacedKey.fromString("select_slot"), PersistentDataType.INTEGER);
            slot++;

            meta.getPersistentDataContainer().set(NamespacedKey.fromString("select_slot"), PersistentDataType.INTEGER, slot);

            item.setItemMeta(meta);
        }
    }
}
