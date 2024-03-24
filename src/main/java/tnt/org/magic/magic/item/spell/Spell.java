package tnt.org.magic.magic.item.spell;

import org.bukkit.Material;

public enum Spell {

    FIRE_WAND(
            30,
            "§6§lОгненое кольцо",
            "§7Поджигает врагов вокруг себя в радиусе 3 блоков",
            Material.EMERALD,
            "fire_ring"
    ),

    BAT_STAFF(
            60,
            "§4§lВампирский побег",
            "§7Создаёт летучих мышей и накладывает: скорость 2, регенерацию 2 и невидимость",
            Material.EMERALD,
            "escape"
    ),

    LIVE_STEAL(
            40,
            "§c§lКража жизни",
            "§7Забирает 2 сердца у вашего врага и отдаёт их вам",
            Material.EMERALD,
            "live_steal"
    ),

    FROST_STORM(
            80,
            "§f§lМорозная буря",
            "§7Создаёт бурю вокруг вас, которая замедляет врагов",
            Material.EMERALD,
            "frost_storm"
    );


    private int mana;
    private String name;
    private String lore;
    private Material material;
    private String tag;

    Spell(int mana, String name, String lore, Material material, String tag) {
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
