package com.kuronosu.tutorialmod.item.custom;

import com.kuronosu.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    public static final Map<Block, Block> CHISEL_LOOKUP = new HashMap<>();

    public static void registerChiselLookup() {
        CHISEL_LOOKUP.put(Blocks.STONE, Blocks.STONE_BRICKS);
        CHISEL_LOOKUP.put(Blocks.STONE_BRICKS, Blocks.STONE);
        CHISEL_LOOKUP.put(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        CHISEL_LOOKUP.put(Blocks.END_STONE_BRICKS, Blocks.END_STONE);
        CHISEL_LOOKUP.put(Blocks.OAK_LOG, ModBlocks.PINK_GARNET_BLOCK);
        CHISEL_LOOKUP.put(Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK);
        CHISEL_LOOKUP.put(ModBlocks.PINK_GARNET_BLOCK, ModBlocks.MAGIC_BLOCK);
    }


    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_LOOKUP.containsKey(clickedBlock)) {
            if(!world.isClient){
             world.setBlockState(context.getBlockPos(), CHISEL_LOOKUP.get(clickedBlock).getDefaultState());

             context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                     item -> {
                         assert context.getPlayer() != null;
                         context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND );
                     });

             world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.tutorialmod.chisel.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.tutorialmod.chisel"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}

