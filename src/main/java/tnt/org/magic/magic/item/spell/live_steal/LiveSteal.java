package tnt.org.magic.magic.item.spell.live_steal;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import tnt.org.magic.magic.item.spell.Spell;
import tnt.org.magic.magic.item.spell.SpellCreate;

public class LiveSteal {

    private static final Spell spell = Spell.LIVE_STEAL;

    public static void init(){
        recipe();
    }
    public static ItemStack liveSteal = SpellCreate.createSpell(spell);


    private static void recipe() {

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft(spell.getTag()), liveSteal);

        shapedRecipe.shape(
                "WFW",
                "RNR",
                "WFW"
        );
        shapedRecipe.setIngredient('W', Material.NETHER_WART);
        shapedRecipe.setIngredient('R', Material.RED_DYE);
        shapedRecipe.setIngredient('F', Material.FERMENTED_SPIDER_EYE);
        shapedRecipe.setIngredient('N', Material.NETHER_STAR);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}
