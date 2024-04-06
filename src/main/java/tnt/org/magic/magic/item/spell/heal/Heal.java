package tnt.org.magic.magic.item.spell.heal;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.item.spell.SpellCreate;

public class Heal {
    private static final Spell spell = Spell.HEAL;

    public static void init(){
        recipe();
    }
    public static ItemStack heal = SpellCreate.createSpell(spell);


    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(spell.getTag()), heal);

        shapedRecipe.shape(
                "AGA",
                "GBG",
                "AGA"
        );
        shapedRecipe.setIngredient('A', Material.GOLDEN_APPLE);
        shapedRecipe.setIngredient('G', Material.GOLD_INGOT);
        shapedRecipe.setIngredient('B', Material.MILK_BUCKET);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }




}
