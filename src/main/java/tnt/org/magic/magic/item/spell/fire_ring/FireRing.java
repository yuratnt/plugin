package tnt.org.magic.magic.item.spell.fire_ring;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.spell.SpellCreate;
import tnt.org.magic.magic.item.spell.Spell;

public class FireRing {

    private static final Spell spell = Spell.FIRE_WAND;

    public static void init(){
        recipe();
    }
    public static ItemStack fireRing = SpellCreate.createSpell(spell);


    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(spell.getTag()), fireRing);

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
