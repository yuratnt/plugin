package tnt.org.magic.magic.item.inventory_filler;

import org.bukkit.Material;

public enum Filler {
    BLACK_GLASS_PANE(
            "§0.",
            "",
            Material.BLACK_STAINED_GLASS_PANE,
            "black_panel"
    );

    private String name;
    private String lore;
    private Material material;
    private String tag;

    Filler(String name, String lore, Material material, String tag) {
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

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }
}
