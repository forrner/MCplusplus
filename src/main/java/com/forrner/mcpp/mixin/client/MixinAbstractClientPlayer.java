package com.forrner.mcpp.mixin.client;

import com.forrner.mcpp.item.custom.LeadBowItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {

    @Inject(method = "getFieldOfViewModifier", at = @At("RETURN"), cancellable = true)
    private void onGetFieldOfViewModifier(boolean firstPerson, float effectScale, CallbackInfoReturnable<Float> cir) {
        Player player = (Player) (Object) this;

        if (player.isUsingItem() && player.getUseItem().getItem() instanceof LeadBowItem) {
            float scale = Math.min(player.getTicksUsingItem() / 20.0F, 1.0F);
            float modifier = 1.0F - Mth.square(scale) * 0.15F;
            cir.setReturnValue(Mth.lerp(effectScale, 1.0F, modifier));
        }
    }
}