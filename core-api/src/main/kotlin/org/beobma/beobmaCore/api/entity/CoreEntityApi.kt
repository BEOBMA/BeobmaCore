package org.beobma.beobmaCore.api.entity

import org.bukkit.FluidCollisionMode
import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import java.util.function.Predicate

interface CoreEntityApi {
    /**
     * 엔티티의 최대 체력을 반환한다.
     * @return 엔티티의 최대 체력
     */
    fun Entity.getMaxHealth(): Double

    /**
     * 엔티티의 최대 체력을 설정한다.
     * @param value 설정할 최대 체력
     */
    fun Entity.setMaxHealth(value: Double)

    /**
     * 엔티티가 특정 영역 내에 있는지 여부를 반환한다.
     * @param loc1 영역 꼭짓점 1
     * @param loc2 영역 꼭짓점 2
     * @return 특정 영역 내에 있는지 여부
     */
    fun Entity.isInArea(loc1: Location, loc2: Location): Boolean

    /**
     * 엔티티가 바라보고 있는 엔티티를 반환한다.
     * @param distance 최대 거리
     * @param raySize 바라보고 있는 판정 사이즈
     * @param ignoreBlock 블록을 무시할지 여부
     * @param fluidCollisionMode 블록을 무시하지 않을 때, 액체와 관련된 동작 방식
     * @param ignorePassableBlocks 블록을 무시하지 않을 때, 표지판과 같은 블록을 무시할지 여부
     * @param filter 필터링할 엔티티
     * @return 엔티티가 바라보고 있는 엔티티
     */
    fun Entity.getViewEntity(
        distance: Double,
        raySize: Double,
        ignoreBlock: Boolean,
        fluidCollisionMode: FluidCollisionMode = FluidCollisionMode.NEVER,
        ignorePassableBlocks: Boolean = true,
        filter: Predicate<in Entity>? = { entity -> entity != this },
    ): Entity?

    /**
     * 엔티티가 바라보고 있는 블록을 반환한다.
     * @param distance 최대 거리
     * @param raySize 바라보고 있는 판정 사이즈
     * @param fluidCollisionMode 블록을 무시하지 않을 때, 액체와 관련된 동작 방식
     * @param ignorePassableBlocks 블록을 무시하지 않을 때, 표지판과 같은 블록을 무시할지 여부
     * @return 엔티티가 바라보고 있는 블록
     */
    fun Entity.getViewBlock(
        distance: Double,
        raySize: Double,
        fluidCollisionMode: FluidCollisionMode = FluidCollisionMode.NEVER,
        ignorePassableBlocks: Boolean = true,
    ): Block?
}