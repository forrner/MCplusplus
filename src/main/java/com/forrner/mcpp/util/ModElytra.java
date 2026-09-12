package com.forrner.mcpp.util;

import com.forrner.mcpp.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class ModElytra {
    public static void register() {
        EntityElytraEvents.CUSTOM.register((entity, tickElytra) -> {
            ItemStack chestStack = entity.getItemBySlot(EquipmentSlot.CHEST);
            boolean isWearingSuperElytra = (chestStack.getItem() == ModItems.LUMEN_ELYTRA)||(chestStack.getItem() == ModItems.UMBRA_ELYTRA);

            if (!isWearingSuperElytra) return false;
            if (chestStack.nextDamageWillBreak()) return false;

            if (tickElytra && entity instanceof Player player) {
                Vec3 velocity = player.getDeltaMovement();
                player.setDeltaMovement(new Vec3(velocity.x * 1.5, velocity.y, velocity.z * 1.5));
                if (!chestStack.nextDamageWillBreak()) {
                    chestStack.hurtAndBreak(1, player, EquipmentSlot.CHEST);
                }
            }
            return true;
        });
    }
}