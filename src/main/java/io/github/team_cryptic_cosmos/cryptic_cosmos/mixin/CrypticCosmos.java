package io.github.team_cryptic_cosmos.cryptic_cosmos.mixin;

import io.github.team_cryptic_cosmos.cryptic_cosmos.mixin.regestries.ItemRegisters;
import net.fabricmc.api.ModInitializer;

public class CrypticCosmos implements ModInitializer {
    public static final String MOD_ID = "cryptcos";
    @Override
    public void onInitialize() {
        ItemRegisters.registerItems();
    }
}
