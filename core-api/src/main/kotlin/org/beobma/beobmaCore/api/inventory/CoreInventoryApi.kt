package org.beobma.beobmaCore.api.inventory

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory

interface CoreInventoryApi {
    fun createInventory(inventoryTitle: Component, inventoryType: InventoryType, owner: Player? = null): Inventory
}