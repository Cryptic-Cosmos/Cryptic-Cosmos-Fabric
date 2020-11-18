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

package io.github.team_mythoscraft.mythoscraft

import io.github.team_mythoscraft.mythoscraft.registries.ItemRegistries
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager

object MythosCraft : ModInitializer {
    private const val MOD_ID = "mythoscraft"
    private val LOGGER = LogManager.getLogger()
    val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.build(id("item_group")) {
        ItemStack(Items.DIRT)
    }

    @JvmStatic
    fun id(path: String): Identifier = Identifier(MOD_ID, path)

    override fun onInitialize() {
        // TODO: data generation, port all the other stuff

        ItemRegistries.loadAll()

        LOGGER.info("haha yes")
    }
}