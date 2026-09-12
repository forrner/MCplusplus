package com.forrner.mcpp.util;

import com.forrner.mcpp.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.end.EnderDragonFight;

public class ModEvents {

    public static boolean hasKilledEnderDragon(MinecraftServer server) {
        ServerLevel endWorld = server.getLevel(Level.END);
        if (endWorld == null) {
            return false;
        }
        EnderDragonFight enderDragonFight = endWorld.getDragonFight();
        return enderDragonFight.hasPreviouslyKilledDragon();
    }

    public static void register() {
        ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
            if (livingEntity.level().isClientSide()) return;
            if (!(livingEntity instanceof EnderDragon)) return;
            MutableComponent msg = Component.translatable("message.mcpp.enderdragonkilled");
            livingEntity.level().getServer().getPlayerList().getPlayers()
                    .forEach(player -> player.sendSystemMessage(msg));
        });

        ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
            if (livingEntity.level().isClientSide()) return;
            if (!(livingEntity instanceof Phantom phantom)) return;

            MinecraftServer server = livingEntity.level().getServer();
            boolean dragonKilled = hasKilledEnderDragon(server);
            if (!dragonKilled) return;

            float chance = 0.1F;
            float rand = phantom.level().getRandom().nextFloat();
            if (rand <= chance) {
                ItemStack drop = new ItemStack(ModItems.UMBRA_FEATHER);
                ItemEntity itemEntity = new ItemEntity(
                        phantom.level(),
                        phantom.getX(), phantom.getY(), phantom.getZ(),
                        drop
                );
                itemEntity.setDefaultPickUpDelay();
                phantom.level().addFreshEntity(itemEntity);
            }
        });

        ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
            if (livingEntity.level().isClientSide()) return;
            if (!(livingEntity instanceof Allay allay)) return;

            MinecraftServer server = livingEntity.level().getServer();
            boolean dragonKilled = hasKilledEnderDragon(server);
            if (!dragonKilled) return;

            float chance = 0.1F;
            float rand = allay.level().getRandom().nextFloat();
            if (rand <= chance) {
                ItemStack drop = new ItemStack(ModItems.LUMEN_FEATHER);
                ItemEntity itemEntity = new ItemEntity(
                        allay.level(),
                        allay.getX(), allay.getY(), allay.getZ(),
                        drop
                );
                itemEntity.setDefaultPickUpDelay();
                allay.level().addFreshEntity(itemEntity);
            }
        });

    }
}
