package tnt.org.magic.magic.item.spell.fire_ray;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.item.spell.SpellCreate;

public class FireRay {
    private static final Spell spell = Spell.FIRE_RAY;

    public static void init(){
        recipe();
    }

    public static ItemStack fireRay = SpellCreate.createSpell(spell);


    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(spell.getTag()), fireRay);

        shapedRecipe.shape(
                "RBR",
                "BSB",
                "RBR"
        );
        shapedRecipe.setIngredient('R', Material.REDSTONE_BLOCK);
        shapedRecipe.setIngredient('B', Material.BLAZE_POWDER);
        shapedRecipe.setIngredient('S', Material.FLINT_AND_STEEL);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}
