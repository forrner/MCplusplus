package com.forrner.mcpp.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Environment(EnvType.CLIENT)
@Mixin(Gui.class)
public class MixinGui {

    /**
     * @reason 支持显示 30 点护甲值，超出 20 点的部分在第二行显示
     *         小于等于 20 点时显示空图标（与原版一致）
     * @author forrner
     */
    @Overwrite
    private static void extractArmor(
            final GuiGraphicsExtractor graphics,
            final Player player,
            final int yLineBase,
            final int numHealthRows,
            final int healthRowHeight,
            final int xLeft
    ) {
        int armor = player.getArmorValue();
        if (armor <= 0) return;

        Identifier ARMOR_EMPTY_SPRITE = Identifier.withDefaultNamespace("hud/armor_empty");
        Identifier ARMOR_HALF_SPRITE = Identifier.withDefaultNamespace("hud/armor_half");
        Identifier ARMOR_FULL_SPRITE = Identifier.withDefaultNamespace("hud/armor_full");

        int firstRowIcons = 10;
        int secondRowIcons = 0;
        if (armor > 20) {
            secondRowIcons = Math.min((armor - 20 + 1) / 2, 5);
        }

        int yLineArmor = yLineBase - (numHealthRows - 1) * healthRowHeight - 10;
        int yLineArmorSecond = yLineArmor - 10;

        for (int i = 0; i < firstRowIcons; i++) {
            int xo = xLeft + i * 8;
            if (i * 2 + 1 < armor) {
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ARMOR_FULL_SPRITE, xo, yLineArmor, 9, 9);
            } else if (i * 2 + 1 == armor) {
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ARMOR_HALF_SPRITE, xo, yLineArmor, 9, 9);
            } else {
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ARMOR_EMPTY_SPRITE, xo, yLineArmor, 9, 9);
            }
        }

        if (secondRowIcons > 0) {
            int offsetArmor = 20;
            for (int i = 0; i < secondRowIcons; i++) {
                int xo = xLeft + i * 8;
                int currentArmor = offsetArmor + i * 2;
                if (currentArmor + 1 < armor) {
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ARMOR_FULL_SPRITE, xo, yLineArmorSecond, 9, 9);
                } else if (currentArmor + 1 == armor) {
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ARMOR_HALF_SPRITE, xo, yLineArmorSecond, 9, 9);
                }
            }
        }
    }
}