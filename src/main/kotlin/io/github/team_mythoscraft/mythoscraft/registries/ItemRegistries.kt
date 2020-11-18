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
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

@Suppress("UNUSED")
object ItemRegistries {
    private fun register(id: String, item: Item) = Registry.register(Registry.ITEM, MythosCraft.id(id), item)

    private val DEFAULT_ITEM_PROPERTY: Item.Settings = Item.Settings().group(MythosCraft.ITEM_GROUP)

    val HUMMING_INGOT: Item = register("humming_ingot", Item(DEFAULT_ITEM_PROPERTY))
}