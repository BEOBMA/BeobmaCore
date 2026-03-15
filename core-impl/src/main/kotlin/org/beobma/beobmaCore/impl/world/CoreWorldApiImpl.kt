package org.beobma.beobmaCore.impl.world

import org.beobma.beobmaCore.api.world.CoreWorldApi
import org.bukkit.Bukkit
import org.bukkit.World

class CoreWorldApiImpl : CoreWorldApi {
    override fun getWorld(): World {
        return Bukkit.getWorlds().first()
    }
}