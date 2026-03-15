package org.beobma.beobmaCore.api.item

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


interface CoreItemApi {
    fun createItemStack(name: Component, description: List<Component>, material: Material, customModelData: Int, amount: Int = 1): ItemStack
}