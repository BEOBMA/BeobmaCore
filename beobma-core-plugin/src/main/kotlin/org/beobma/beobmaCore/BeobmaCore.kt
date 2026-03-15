package org.beobma.beobmaCore

import org.beobma.beobmaCore.api.log.CoreLogApi
import org.beobma.beobmaCore.impl.log.CoreLogApiImpl
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

class BeobmaCore : JavaPlugin() {
    override fun onEnable() {
        val api: CoreLogApi = CoreLogApiImpl("[BeobmaCore]")

        server.servicesManager.register(
            CoreLogApi::class.java,
            api,
            this,
            ServicePriority.Normal,
        )

        logger.info(api.formatInfo("CoreMessageApi service registered."))
    }

    override fun onDisable() {
        server.servicesManager.unregisterAll(this)
    }
}
