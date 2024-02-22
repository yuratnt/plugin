package tnt.org.magic.magic.item.spell.escape;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.spell.SpellCreate;
import tnt.org.magic.magic.item.spell.Spell;

public class Escape {

    private static final Spell spell = Spell.BAT_STAFF;

    public static ItemStack escape = SpellCreate.createStaff(spell);

    public static void init() {
        recipe();
    }

    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(spell.getTag()), escape);

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
