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

package io.github.team_mythoscraft.mythoscraft.registries

import io.github.team_mythoscraft.mythoscraft.MythosCraft
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

@Suppress("UNUSED")
object BlockRegistries {
    private fun register(id: String, block: Block, registerBlockItem: Boolean = true): Block {
        if (registerBlockItem) {
            Registry.register(Registry.ITEM, MythosCraft.id(id), BlockItem(block, ItemRegistries.DEFAULT_ITEM_PROPERTY))
        }

        return Registry.register(Registry.BLOCK, MythosCraft.id(id), block)
    }
}