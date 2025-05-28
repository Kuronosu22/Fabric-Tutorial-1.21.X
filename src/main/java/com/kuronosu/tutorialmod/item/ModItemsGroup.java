package com.kuronosu.tutorialmod.item;

import com.kuronosu.tutorialmod.TutorialMod;
import com.kuronosu.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup PINK_GARNET_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModItems.CHISEl);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.COPPER_BUCKET);
                        entries.add(ModItems.WATER_COPPER_BUCKET);
                        entries.add(ModItems.LAVA_COPPER_BUCKET);
                        entries.add(ModItems.STARLIGHT_ASHES);
                    }).build()
    );

    public static void registerModItemsGroup() {
        TutorialMod.LOGGER.info("Registering Mod items Group for " + TutorialMod.MOD_ID);
    }
}
