package tnt.org.magic.magic.item.staff;

import org.bukkit.Material;
import tnt.org.magic.magic.mechanic.mana.Mana;

import java.util.Collections;
import java.util.List;

public enum Staff {

    FIRE_WAND(
            10,
            "§6Огненый жезл",
            "§7Поджигает врагов вокруг себя в радиусе 3 блоков, если в левой руке есть 1 огненый порошок",
            Material.STICK,
            "fire_wand"),

    BAT_STAFF(
            30,
            "§4Вампирский посох",
            "lore",
            Material.STICK,
            "bat_staff");


    private int mana;
    private String name;
    private String lore;
    private Material material;
    private String tag;

    Staff(int mana, String name, String lore, Material material, String tag) {
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

    public List<String> getLore() {
        return Collections.singletonList(lore);
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
