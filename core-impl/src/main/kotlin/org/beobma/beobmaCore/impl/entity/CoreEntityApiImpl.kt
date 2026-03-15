package org.beobma.beobmaCore.impl.entity

import org.beobma.beobmaCore.api.entity.CoreEntityApi
import org.bukkit.FluidCollisionMode
import org.bukkit.Location
import org.bukkit.attribute.Attribute
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.util.BoundingBox
import java.util.function.Predicate

class CoreEntityApiImpl : CoreEntityApi {
    override fun Entity.getMaxHealth(): Double {
        require(this is LivingEntity) { "LivingEntity가 아님." }

        return this.getAttribute(Attribute.MAX_HEALTH)?.value ?: 0.0
    }

    override fun Entity.setMaxHealth(value: Double) {
        require(this is LivingEntity) { "LivingEntity가 아님." }

        this.getAttribute(Attribute.MAX_HEALTH)?.baseValue = value
    }

    override fun Entity.isInArea(loc1: Location, loc2: Location): Boolean {
        require(loc1.world == loc2.world) { "두 Location의 world가 같지 않음." }
        val box = BoundingBox.of(loc1, loc2)
        return this.boundingBox.overlaps(box)
    }

    override fun Entity.getViewEntity(
        distance: Double,
        raySize: Double,
        ignoreBlock: Boolean,
        fluidCollisionMode: FluidCollisionMode,
        ignorePassableBlocks: Boolean,
        filter: Predicate<in Entity>?,
    ): Entity? {
        require(this is LivingEntity) { "LivingEntity가 아님." }
        val eyeLocation = eyeLocation

        // 블록을 무시하지 않음
        if (!ignoreBlock) {
            val blockRayTraceResult = world.rayTraceBlocks(
                eyeLocation,
                eyeLocation.direction,
                distance,
                fluidCollisionMode,
                ignorePassableBlocks
            )
            if (blockRayTraceResult != null) return null
        }

        val entityRayTraceResult =
            world.rayTraceEntities(eyeLocation, eyeLocation.direction, distance, raySize, filter)
        val hitEntity = entityRayTraceResult?.hitEntity
        return hitEntity
    }

    override fun Entity.getViewBlock(
        distance: Double,
        raySize: Double,
        fluidCollisionMode: FluidCollisionMode,
        ignorePassableBlocks: Boolean,
    ): Block? {
        require(this is LivingEntity) { "LivingEntity가 아님." }
        val eyeLocation = eyeLocation

        val blockRayTraceResult = world.rayTraceBlocks(
            eyeLocation,
            eyeLocation.direction,
            distance,
            fluidCollisionMode,
            ignorePassableBlocks
        )
        return blockRayTraceResult?.hitBlock
    }
}