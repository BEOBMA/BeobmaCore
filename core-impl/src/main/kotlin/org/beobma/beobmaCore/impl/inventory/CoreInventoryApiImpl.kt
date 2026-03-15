package org.beobma.beobmaCore.impl.inventory

import net.kyori.adventure.text.Component
import org.beobma.beobmaCore.api.inventory.CoreInventoryApi
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory

class CoreInventoryApiImpl : CoreInventoryApi {
    override fun createInventory(inventoryTitle: Component, inventoryType: InventoryType, owner: Player?): Inventory {
        val inventory = Bukkit.createInventory(owner, inventoryType, inventoryTitle)
        return inventory
    }

}