package me.exerosis.gameengine.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class ItemFilter implements Filter<ItemStack> {


    private Collection<Material> materials;

    private Collection<MaterialData> materialDatas;

    private boolean whiteList;

    public ItemFilter(boolean whiteList)
    {
        this(null, null, whiteList);
    }

    public ItemFilter(Collection<Material> materials)
    {
        this(materials, null, true);
    }

    public ItemFilter(Collection<Material> materials, boolean whiteList)
    {
        this(materials, null, whiteList);
    }

    public ItemFilter(Collection<Material> materials, Collection<MaterialData> materialDatas)
    {
        this(materials, materialDatas, true);
    }


    public ItemFilter(Collection<Material> materials, Collection<MaterialData> materialDatas, boolean whiteList)
    {
        if (materials == null)
            materials = new ArrayList<Material>();
        if (materialDatas == null)
            materialDatas = new ArrayList<MaterialData>();

        this.materials = materials;
        this.materialDatas = materialDatas;
        this.whiteList = whiteList;
    }

    @Override
    public boolean filter(ItemStack item)
    {
        return this.whiteList == (materials.contains(item.getType()) || materialDatas.contains(item.getData()));
    }
}
