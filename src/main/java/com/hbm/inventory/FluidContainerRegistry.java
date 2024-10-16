package com.hbm.inventory;

import com.hbm.blocks.ModBlocks;
import com.hbm.config.GeneralConfig;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.items.ModItems;
import com.hbm.util.Compat;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FluidContainerRegistry {

    //TODO: continue incorporating hashmaps into this
    public static List<FluidContainer> allContainers = new ArrayList<FluidContainer>();
    private static HashMap<FluidType, List<FluidContainer>> containerMap = new HashMap<FluidType, List<FluidContainer>>();

    public static void register() {
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.BUCKET), Fluids.WATER, 1000));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(Items.POTIONITEM), new ItemStack(Items.GLASS_BOTTLE), Fluids.WATER, 250));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(Items.LAVA_BUCKET), new ItemStack(Items.BUCKET), Fluids.LAVA, 1000));

        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModBlocks.red_barrel), new ItemStack(ModItems.tank_steel), Fluids.DIESEL, 10000));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModBlocks.pink_barrel), new ItemStack(ModItems.tank_steel), Fluids.KEROSENE, 10000));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModBlocks.lox_barrel), new ItemStack(ModItems.tank_steel), Fluids.OXYGEN, 10000));

        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModBlocks.ore_oil), null, Fluids.OIL, 250));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModBlocks.ore_gneiss_gas), null, Fluids.PETROLEUM, GeneralConfig.enable528 ? 50 : 250));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModItems.bottle_mercury), new ItemStack(Items.GLASS_BOTTLE), Fluids.MERCURY, 1000));

        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModItems.particle_hydrogen), new ItemStack(ModItems.particle_empty), Fluids.HYDROGEN, 1000));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModItems.particle_amat), new ItemStack(ModItems.particle_empty), Fluids.AMAT, 1000));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModItems.particle_aschrab), new ItemStack(ModItems.particle_empty), Fluids.ASCHRAB, 1000));

        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModItems.iv_blood), new ItemStack(ModItems.iv_empty), Fluids.BLOOD, 100));
        FluidContainerRegistry.registerContainer(new FluidContainer(new ItemStack(ModItems.iv_xp), new ItemStack(ModItems.iv_xp_empty), Fluids.XPJUICE, 100));
    }

    public static void registerContainer(FluidContainer con) {
        allContainers.add(con);
        OreDictionary.registerOre(con.type.getDict(con.content), con.fullContainer);

        if(!containerMap.containsKey(con.type))
            containerMap.put(con.type, new ArrayList<FluidContainer>());

        List<FluidContainer> items = containerMap.get(con.type);
        items.add(con);
    }

    public static List<FluidContainer> getContainers(FluidType type) {
        return containerMap.get(type);
    }

    public static FluidContainer getContainer(FluidType type, ItemStack stack) {
        if(stack == null)
            return null;

        ItemStack sta = stack.copy();
        sta.setCount(1);

        if (!containerMap.containsKey(type))
            return null;

        for (FluidContainer container : getContainers(type)) {
            if (ItemStack.areItemStacksEqual(container.emptyContainer, sta) && ItemStack.areItemStackTagsEqual(container.emptyContainer, sta)) {
                return container;
            }
        }

        return null;
    }

    public static int getFluidContent(ItemStack stack, FluidType type) {

        if(stack == null)
            return 0;

        ItemStack sta = stack.copy();
        sta.setCount(1);

        if (!containerMap.containsKey(type))
            return 0;

        for(FluidContainer container : containerMap.get(type)) {
            if(ItemStack.areItemStacksEqual(container.fullContainer, sta) && ItemStack.areItemStackTagsEqual(container.fullContainer, sta))
                return container.content;
        }

        return 0;
    }

    public static FluidType getFluidType(ItemStack stack) {

        if(stack == null)
            return Fluids.NONE;

        ItemStack sta = stack.copy();
        sta.setCount(1);

        for(FluidContainer container : allContainers) {
            if(ItemStack.areItemStacksEqual(container.fullContainer, sta) && ItemStack.areItemStackTagsEqual(container.fullContainer, sta))
                return container.type;
        }

        return Fluids.NONE;
    }

    public static ItemStack getFullContainer(ItemStack stack, FluidType type) {
        if(stack == null)
            return null;

        ItemStack sta = stack.copy();
        sta.setCount(1);

        if (!containerMap.containsKey(type))
            return null;

        for(FluidContainer container : containerMap.get(type)) {
            if(ItemStack.areItemStacksEqual(container.emptyContainer, sta) &&  ItemStack.areItemStackTagsEqual(container.emptyContainer, sta))
                return container.fullContainer.copy();
        }

        return null;
    }

    public static ItemStack getEmptyContainer(ItemStack stack) {
        if(stack == null)
            return null;

        ItemStack sta = stack.copy();
        sta.setCount(1);

        for(FluidContainer container : allContainers) {
            if(ItemStack.areItemStacksEqual(container.fullContainer, sta) && ItemStack.areItemStackTagsEqual(container.fullContainer, sta))
                return container.emptyContainer == null ? null : container.emptyContainer.copy();
        }

        return null;
    }

}
