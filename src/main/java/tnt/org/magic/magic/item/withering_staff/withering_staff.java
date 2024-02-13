package tnt.org.magic.magic.item.withering_staff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.item_create;

import java.util.Collections;

public class withering_staff {

    public static ItemStack withering_staff = item_create.createItem(
            Material.STICK,
            "withering staff",
            Collections.singletonList("Lore")
    );

    public static void init() {
        Recipe();
    }

    private static void Recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("withering_staff"), withering_staff);

        shapedRecipe.shape(
                " AH",
                " NA",
                "B  "
        );
        shapedRecipe.setIngredient('A', Material.AMETHYST_SHARD);
        shapedRecipe.setIngredient('H', Material.WITHER_SKELETON_SKULL);
        shapedRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}