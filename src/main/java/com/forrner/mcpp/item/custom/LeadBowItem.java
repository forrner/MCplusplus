package com.forrner.mcpp.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import org.jetbrains.annotations.NotNull;

public class LeadBowItem extends BowItem {
    public LeadBowItem(Properties properties) {
        super(properties);
    }

    private static final float ARROW_VELOCITY_MULTIPLIER = 1.2F;
    private static final float ARROW_INACCURACY = 0.5F;

    @Override
    protected void shootProjectile(
            @NotNull LivingEntity shooter,
            Projectile projectileEntity,
            int index,
            float power,
            float uncertainty,
            float angle,
            LivingEntity targetOverride
    ) {
        projectileEntity.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F,
                power * ARROW_VELOCITY_MULTIPLIER, ARROW_INACCURACY);
    }
}
