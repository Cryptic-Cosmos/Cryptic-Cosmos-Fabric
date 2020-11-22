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

package io.github.team_mythoscraft.mythoscraft.datagen

import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import io.github.team_mythoscraft.mythoscraft.MythosCraft
import io.github.team_mythoscraft.mythoscraft.registries.ItemRegistries
import me.shedaniel.cloth.api.datagen.v1.DataGeneratorHandler
import net.fabricmc.api.ModInitializer
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.commons.lang3.text.WordUtils
import org.apache.logging.log4j.LogManager
import java.nio.file.Paths
import kotlin.reflect.full.memberProperties
import kotlin.system.exitProcess

object MythosCraftDatagen : ModInitializer {
    private val LOGGER = LogManager.getLogger()

    override fun onInitialize() {
        try {
            val handler = DataGeneratorHandler.create(Paths.get("../src/generated/resources"))

            val klass = ItemRegistries::class
            val itemProperties = klass.memberProperties
                .map { it.get(klass.objectInstance!!) }
                .filterIsInstance<Item>()
            val languageJson = JsonObject()

            for (item in itemProperties) {
                handler.modelStates.addHandheldItemModel(item)

                if (item is ToolItem || item is ShearsItem) {
                    val tag = when (item) {
                        is SwordItem -> "swords"
                        is PickaxeItem -> "pickaxes"
                        is AxeItem -> "axes"
                        is ShovelItem -> "shovels"
                        is HoeItem -> "hoes"
                        is ShearsItem -> "shears"
                        else -> error("update datagen pls")
                    }

                    handler.tags.item(Identifier("fabric", tag)).appendOptional(item)

                    /*
                    ShapedRecipeJsonFactory
                        .create { item }
                        .apply {
                            when (item) {
                                is SwordItem -> this.group("swords")
                                    .input('s', Items.STICK)
                                    .input('')
                            }
                        }
                        .offerTo { handler.recipes.accept(it) }
                        */
                }

                languageJson.add(
                    item.translationKey,
                    JsonPrimitive(
                        WordUtils.capitalizeFully(
                            Registry.ITEM
                                .getId(item)
                                .path
                                .replace("_", " ")
                        )
                    )
                )
            }

            handler.simple.addJson("assets/${MythosCraft.MOD_ID}/lang/en_us.json", languageJson)

            handler.run()
        } catch (throwable: Throwable) {
            LOGGER.fatal("Error happened during datagen!", throwable)
            exitProcess(1)
        }

        LOGGER.info("thanks for flying on datagen airways™, we are approaching the runway")

        exitProcess(0)

        @Suppress("UNREACHABLE_CODE") // this is for the haha funi
        LOGGER.fatal("oh shit")
    }
}