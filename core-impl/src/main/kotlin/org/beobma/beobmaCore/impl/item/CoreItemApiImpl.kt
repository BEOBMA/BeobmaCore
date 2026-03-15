package org.beobma.beobmaCore.impl.item

import net.kyori.adventure.text.Component
import org.beobma.beobmaCore.api.item.CoreItemApi
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CoreItemApiImpl : CoreItemApi {
    @Suppress("UnstableApiUsage")
    override fun createItemStack(name: Component, description: List<Component>, material: Material, customModelData: Int, amount: Int): ItemStack {
        val itemStack = ItemStack(material, amount)
        val itemMeta = itemStack.itemMeta ?: return itemStack
        val customModelDataComponent = itemMeta.customModelDataComponent
        customModelDataComponent.floats = listOf(customModelData.toFloat())
        itemMeta.displayName(name)
        itemMeta.itemName(name)
        itemMeta.setCustomModelDataComponent(customModelDataComponent)
        itemMeta.lore(description)
        itemStack.itemMeta = itemMeta
        return itemStack
    }


}