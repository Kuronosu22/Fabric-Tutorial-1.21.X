package com.kuronosu.tutorialmod.item;

import com.kuronosu.tutorialmod.TutorialMod;
import com.kuronosu.tutorialmod.item.custom.ChiselItem;
import com.kuronosu.tutorialmod.item.custom.CopperBucketItem;
import com.kuronosu.tutorialmod.item.custom.CopperBucketWithLiquidItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

   public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
   public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

   public static final Item CHISEl = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
   public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)){
      @Override
      public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
         tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower"));
         super.appendTooltip(stack, context, tooltip, type);
      }
   });

   public static final Item COPPER_BUCKET = registerItem("copper_bucket", new CopperBucketItem(new Item.Settings().maxCount(16)));
   public static final Item WATER_COPPER_BUCKET = registerItem("water_copper_bucket", new CopperBucketWithLiquidItem(Fluids.WATER, new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)));
   public static final Item LAVA_COPPER_BUCKET = registerItem("lava_copper_bucket", new CopperBucketWithLiquidItem(Fluids.LAVA, new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)));

   public static final  Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

   private static Item registerItem(String name, Item item) {
      return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
   }

   public static void registerModItems() {
      TutorialMod.LOGGER.info("Registering Mod items for " + TutorialMod.MOD_ID);
   }
}
