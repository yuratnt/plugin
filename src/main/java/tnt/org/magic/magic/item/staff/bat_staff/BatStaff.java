package tnt.org.magic.magic.item.staff.bat_staff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.ItemCreate;
import tnt.org.magic.magic.item.staff.Staff;

import java.util.Collections;

public class BatStaff {

    public static ItemStack withering_staff = ItemCreate.createStaff(
            Staff.BAT_STAFF.getMana(),
            Staff.BAT_STAFF.getName(),
            Staff.BAT_STAFF.getLore(),
            Staff.BAT_STAFF.getMaterial(),
            Staff.BAT_STAFF.getTag()
    );

    public static void init() {
        Recipe();
    }

    private static void Recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("withering_staff"), withering_staff);

        shapedRecipe.shape(
                " AG",
                " NA",
                "B  "
        );
        shapedRecipe.setIngredient('A', Material.AMETHYST_SHARD);
        shapedRecipe.setIngredient('G', Material.GOLD_BLOCK);
        shapedRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}