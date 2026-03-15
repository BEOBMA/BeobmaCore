package org.beobma.beobmaCore.impl.entity

import org.beobma.beobmaCore.api.entity.CoreEntityApi
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity

class CoreEntityApiImpl : CoreEntityApi {
    override fun Entity.getMaxHealth(): Double {
        require(this is LivingEntity) { "LivingEntity가 아닙니다: ${this.type}" }
        return this.maxHealth
    }
}