package tnt.org.magic.magic.item.wand.MasterWand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.wand.Wand;
import tnt.org.magic.magic.item.wand.WandCreate;

public class MasterWand {

    private static final Wand wand = Wand.MASTER_WAND;

    public static ItemStack masterWand = WandCreate.createWand(wand);

    public static void init() {
        recipe();
    }
    private static void recipe() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(wand.getTag()), masterWand);

        shapedRecipe.shape(
                " NH",
                " BN",
                "S  "
        );
        shapedRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('H', Material.DRAGON_HEAD);
        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('S', Material.NETHER_STAR);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}
