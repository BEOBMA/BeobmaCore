package org.beobma.beobmaCore.impl.message

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.title.Title
import org.beobma.beobmaCore.api.message.CoreMessageApi
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class CoreMessageApiImpl : CoreMessageApi {
    private val miniMessage: MiniMessage = MiniMessage.miniMessage()

    override fun sendBroadcast(component: Component) {
        Bukkit.broadcast(component)
    }
    override fun List<Player>.sendMessage(component: Component) {
        this.forEach { player ->
            player.sendMessage(component)
        }
    }

    override fun showTitleBroadcast(title: Title) {
        val players = Bukkit.getOnlinePlayers()
        players.forEach { player ->
            player.showTitle(title)
        }
    }
    override fun List<Player>.showTitle(title: Title) {
        this.forEach { player ->
            player.showTitle(title)
        }
    }

    override fun getMiniMessage(): MiniMessage {
        return miniMessage
    }
}