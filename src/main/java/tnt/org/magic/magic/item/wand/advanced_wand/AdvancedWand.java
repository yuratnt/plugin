package tnt.org.magic.magic.item.wand.advanced_wand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.wand.Wand;
import tnt.org.magic.magic.item.wand.WandCreate;

public class AdvancedWand {

    private static final Wand wand = Wand.ADVANCED_WAND;

    public static ItemStack advancedWand = WandCreate.createWand(wand);

    public static void init() {
        recipe();
    }

    private static void recipe() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(wand.getTag()), advancedWand);

        shapedRecipe.shape(
                " SC",
                " BS",
                "E  "
        );
        shapedRecipe.setIngredient('S', Material.SLIME_BALL);
        shapedRecipe.setIngredient('C', Material.ECHO_SHARD);
        shapedRecipe.setIngredient('B', Material.BONE);
        shapedRecipe.setIngredient('E', Material.EMERALD);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}
