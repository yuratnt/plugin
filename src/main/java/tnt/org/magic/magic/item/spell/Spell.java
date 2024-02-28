package tnt.org.magic.magic.item.spell;

import org.bukkit.Material;

public enum Spell {

    FIRE_WAND(
            30,
            "§6§lОгненый жезл",
            "§7Поджигает врагов вокруг себя в радиусе 3 блоков",
            Material.STICK,
            "fire_ring",
            "spell"
            ),

    BAT_STAFF(
            40,
            "§4§lВампирский посох",
            "§7Создаёт летучих мышей и накладывает: скорость 2, регенерацию 2 и невидимость",
            Material.STICK,
            "escape",
            "spell"
            );


    private int mana;
    private String name;
    private String lore;
    private Material material;
    private String tag;

    Spell(int mana, String name, String lore, Material material, String tag, String spell) {
        this.mana = mana;
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.tag = tag;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLore() {
        return lore;
    }
    public void setLore(String lore) {
        this.lore = lore;
    }

    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

}
