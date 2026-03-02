package org.beobma.beobmaCore

import org.beobma.beobmaCore.api.CoreMessageApi
import org.beobma.beobmaCore.impl.CoreMessageApiImpl
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

class BeobmaCore : JavaPlugin() {
    override fun onEnable() {
        val api: CoreMessageApi = CoreMessageApiImpl("[BeobmaCore]")

        server.servicesManager.register(
            CoreMessageApi::class.java,
            api,
            this,
            ServicePriority.Normal,
        )

        logger.info(api.formatInfo("CoreMessageApi service registered."))
        logger.info(api.applyPlaceholders("{plugin} v{version} started", mapOf("plugin" to "BeobmaCore", "version" to pluginMeta.version)))
    }

    override fun onDisable() {
        server.servicesManager.unregisterAll(this)
    }
}
