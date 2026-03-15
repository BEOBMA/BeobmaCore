package org.beobma.beobmaCore.api.message

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.title.Title
import org.bukkit.entity.Player


interface CoreMessageApi {
    fun sendBroadcast(component: Component)
    fun List<Player>.sendMessage(component: Component)

    fun showTitleBroadcast(title: Title)
    fun List<Player>.showTitle(title: Title)

    fun getMiniMessage(): MiniMessage
}