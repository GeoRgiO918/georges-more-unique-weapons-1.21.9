package com.george.more.unique.weapons.other;

import com.george.more.unique.weapons.entity.GravityOrbEntity;
import com.george.more.unique.weapons.item.UniqueWeaponsItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class UniqueWeaponsDispenseBehaviors {

    public static void register() {

        DispenserBlock.registerBehavior(UniqueWeaponsItems.GRAVITY_ORB, new ProjectileDispenserBehavior(UniqueWeaponsItems.GRAVITY_ORB) {
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                World world = pointer.world();
                var direction = pointer.state().get(DispenserBlock.FACING);
                Position pos = DispenserBlock.getOutputLocation(pointer);

                GravityOrbEntity orb = new GravityOrbEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                orb.setVelocity(direction.getOffsetX() * 1.1, direction.getOffsetY() * 1.1, direction.getOffsetZ() * 1.1);

                world.spawnEntity(orb);

                stack.decrement(1);
                return stack;
            }
        });
    }
    }
