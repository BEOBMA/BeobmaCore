package org.beobma.beobmaCore.impl

import org.beobma.beobmaCore.api.CoreMessageApi

class CoreMessageApiImpl(
    private val prefix: String,
) : CoreMessageApi {
    override fun formatGlobalMessage(message: String): String = "$prefix $message"

    override fun formatInfo(message: String): String = "$prefix [INFO] $message"

    override fun formatWarn(message: String): String = "$prefix [WARN] $message"

    override fun formatError(message: String): String = "$prefix [ERROR] $message"

    override fun applyPlaceholders(message: String, values: Map<String, String>): String {
        var result = message
        values.forEach { (key, value) ->
            result = result.replace("{$key}", value)
        }
        return result
    }
}
