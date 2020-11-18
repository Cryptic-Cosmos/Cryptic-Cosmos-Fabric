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