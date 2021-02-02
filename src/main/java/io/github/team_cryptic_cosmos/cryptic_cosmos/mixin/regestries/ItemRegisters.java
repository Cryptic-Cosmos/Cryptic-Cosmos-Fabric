package io.github.team_cryptic_cosmos.cryptic_cosmos.mixin.regestries;

import io.github.team_cryptic_cosmos.cryptic_cosmos.mixin.CrypticCosmos;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegisters {

    public static final Item WAILING_GRAPES = new Item(new Item.Settings().group(ItemGroup.FOOD));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(CrypticCosmos.MOD_ID,"wailing_grapes"), WAILING_GRAPES);
    }
}
