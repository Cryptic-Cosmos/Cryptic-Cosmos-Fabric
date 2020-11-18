package io.github.team_mythoscraft.mythoscraft.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
    @Shadow
    @Nullable
    private String splashText;

    @Inject(method = "init()V", at = @At("TAIL"))
    private void changeSplash(CallbackInfo ci) {
        // little easter egg
        if (ThreadLocalRandom.current().nextInt(200 + 1) == 55) {
            this.splashText = "MythosCraft greets you!";
        }
    }
}
