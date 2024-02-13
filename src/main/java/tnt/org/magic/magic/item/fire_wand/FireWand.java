package tnt.org.magic.magic.item.fire_wand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.ItemCreate;

import java.util.Collections;

public class FireWand {

    public static void init(){
        Recipe();
    }
    public static ItemStack fire_wand = ItemCreate.createItem(
            Material.STICK,
            "§6Огненый жезл",
            Collections.singletonList("§7Поджигает врагов вокруг себя в радиусе 3 блоков, если в левой руке есть 1 огненый порошок")
    );

    private static void Recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("fire_wand"), fire_wand);

        shapedRecipe.shape(
                "  F",
                " B ",
                "B  "
        );
        shapedRecipe.setIngredient('F', Material.FIRE_CHARGE);
        shapedRecipe.setIngredient('B', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}