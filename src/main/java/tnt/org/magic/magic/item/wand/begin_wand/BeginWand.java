package tnt.org.magic.magic.item.wand.begin_wand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.wand.Wand;
import tnt.org.magic.magic.item.wand.WandCreate;

public class BeginWand {

    private static final Wand wand = Wand.BEGIN_WAND;

    public static ItemStack beginWand = WandCreate.createWand(wand);

    public static void init() {
        recipe();
    }

    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(wand.getTag()), beginWand);

        shapedRecipe.shape(
                " AD",
                " SA",
                "S  "
        );
        shapedRecipe.setIngredient('A', Material.AMETHYST_SHARD);
        shapedRecipe.setIngredient('D', Material.DIAMOND);
        shapedRecipe.setIngredient('S', Material.STICK);

        Bukkit.getServer().addRecipe(shapedRecipe);

    }

}
