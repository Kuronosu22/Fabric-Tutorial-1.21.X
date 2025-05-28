package com.kuronosu.tutorialmod.item.custom;

import com.kuronosu.tutorialmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class CopperBucketItem extends Item {
    public CopperBucketItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        BlockHitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos pos = hitResult.getBlockPos();
            BlockState blockState = world.getBlockState(pos);

            if (blockState.getFluidState().isStill()) {
                Fluid fluid = blockState.getFluidState().getFluid();

                if (fluid == Fluids.WATER) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    return TypedActionResult.success(new ItemStack(ModItems.WATER_COPPER_BUCKET), world.isClient());
                }

                if (fluid == Fluids.LAVA) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    return TypedActionResult.success(new ItemStack(ModItems.LAVA_COPPER_BUCKET), world.isClient());
                }
            }
        }

        return TypedActionResult.pass(stack);
    }
}
