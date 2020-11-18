/*
 * Copyright (c) 2020 Team MythosCraft.
 *
 * This file is part of MythosCraft.
 *
 * MythosCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MythosCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MythosCraft.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.team_mythoscraft.mythoscraft.mixin;

import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    @Shadow
    @Final
    private List<String> splashTexts;

    @Inject(
            method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V",
            at = @At("TAIL")
    )
    private void addMythosCraftSplashes(List<String> list, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        // every mods gotta have at least 1 easter egg
        this.splashTexts.addAll(Lists.newArrayList(
                "MythosCraft greets you!",
                "Welcome to MythosCraft!",
                "Don't forget about Lovecraft!"
        ));
    }
}
