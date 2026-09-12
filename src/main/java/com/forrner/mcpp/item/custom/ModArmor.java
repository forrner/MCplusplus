package com.forrner.mcpp.item.custom;

import com.forrner.mcpp.MCplusplus;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ModArmor extends Item {

    private static final Component SET_BONUS_TITLE = Component.translatable(
                    Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, "armor.set_bonus"))
            )
            .withStyle(ChatFormatting.GRAY);

    private static final Component BLAZEARMOR_EFFECT = Component.translatable(
                    Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, "armor.blazearmor_effect"))
            )
            .withStyle(ChatFormatting.GOLD);
    private static final Component VOIDIUMARMOR_EFFECT = Component.translatable(
                    Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MCplusplus.MOD_ID, "armor.voidiumarmor_effect"))
            )
            .withStyle(ChatFormatting.DARK_PURPLE);

    private final Component setBonusDescription;

    public ModArmor(Properties properties, Component setBonusDescription) {
        super(properties);
        this.setBonusDescription = setBonusDescription;
    }

    public static ModArmor createBlazeArmor(Item.Properties properties){
        return new ModArmor(properties, BLAZEARMOR_EFFECT);
    }

    public static ModArmor createVoidiumArmor(Item.Properties properties){
        return new ModArmor(properties, VOIDIUMARMOR_EFFECT);
    }

    @Override
    public void appendHoverText(
            final ItemStack itemStack, final Item.TooltipContext context, final TooltipDisplay display, final Consumer<Component> builder, final TooltipFlag tooltipFlag
    ) {

        builder.accept(SET_BONUS_TITLE);
        builder.accept(CommonComponents.space().append(this.setBonusDescription));
    }
}