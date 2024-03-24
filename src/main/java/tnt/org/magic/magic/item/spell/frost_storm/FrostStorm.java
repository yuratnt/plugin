package tnt.org.magic.magic.item.spell.frost_storm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.item.spell.SpellCreate;

public class FrostStorm {

    private static final Spell spell = Spell.FROST_STORM;

    public static void init(){
        recipe();
    }
    public static ItemStack frostStorm = SpellCreate.createSpell(spell);


    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(spell.getTag()), frostStorm);

        shapedRecipe.shape(
                "SBS",
                "DGD",
                "SBS"
        );
        shapedRecipe.setIngredient('S', Material.SNOWBALL);
        shapedRecipe.setIngredient('D', Material.DRAGON_BREATH);
        shapedRecipe.setIngredient('B', Material.POWDER_SNOW_BUCKET);
        shapedRecipe.setIngredient('G', Material.GHAST_TEAR);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}
