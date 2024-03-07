package tnt.org.magic.magic.item.wand;

import org.bukkit.Material;

public enum Wand {

    BEGIN_WAND(
            "Жезл начинающего мага",
            "Имеет 1 слот для заклинания",
            Material.STICK,
            "begin_wand",
            1
    ),

    ADVANCED_WAND(
            "Жезл продвинутого мага",
            "Имеет 3 слотов для заклинаний",
            Material.STICK,
            "advanced_wand",
            3
    ),

    MASTER_WAND(
            "Жезл архимага",
            "Имеет 5 слот для заклинаний",
            Material.STICK,
            "master_wand",
            5
    );

    private String name;
    private String lore;
    private Material material;
    private String tag;
    private int slotCount;


    Wand(String name, String lore, Material material, String tag, int slotCount) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.tag = tag;
        this.slotCount = slotCount;
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

    public int getSlotCount() {
        return slotCount;
    }
    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }
}
