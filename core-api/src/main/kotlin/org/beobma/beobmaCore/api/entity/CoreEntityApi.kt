package org.beobma.beobmaCore.api.entity

import org.bukkit.entity.Entity

interface CoreEntityApi {
    fun Entity.getMaxHealth(): Double
}