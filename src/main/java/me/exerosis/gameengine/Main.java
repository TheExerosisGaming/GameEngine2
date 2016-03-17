package me.exerosis.gameengine;


import me.exerosis.gameengine.utils.ItemFilter;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class Main {

    public static void main(String[] args)
    {

        MaterialData md = new MaterialData(Material.ACACIA_DOOR);
        MaterialData md1 = new MaterialData(Material.ACACIA_DOOR);

        ItemFilter<MaterialData> oc = new ItemFilter<>(true, new MaterialData[]{md, md});

        System.out.println(oc.contains(new MaterialData(Material.ACACIA_DOOR)));
    }

}
