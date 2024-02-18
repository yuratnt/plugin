package tnt.org.magic.magic.item.wand;

import org.bukkit.Material;

public enum Wand {

    BEGIN_WAND(
            "Жезл начинающего мага",
            "Имеет 1 слот для заклинания",
            Material.STICK,
            "bigin_wand"
    ),

    ADVANCED_WAND(
            "Жезл продвинутого мага",
            "Имеет 3 слотов для заклинаний",
            Material.STICK,
            "advanced_wand"
    ),

    MASTER_WAND(
            "Жезл архимага",
            "Имеет 5 слот для заклинаний",
            Material.STICK,
            "master_wand"
    );

    private String name;

    private String lore;

    private Material material;

    private String tag;

    Wand(String name, String lore, Material material, String tag) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.tag = tag;
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
