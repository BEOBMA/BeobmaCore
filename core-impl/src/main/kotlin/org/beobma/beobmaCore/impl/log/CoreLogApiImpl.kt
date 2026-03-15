package org.beobma.beobmaCore.impl.log

import org.beobma.beobmaCore.api.log.CoreLogApi

class CoreLogApiImpl(
    private val prefix: String,
) : CoreLogApi {
    override fun formatGlobalMessage(message: String): String = "$prefix $message"

    override fun formatInfo(message: String): String = "$prefix [INFO] $message"

    override fun formatWarn(message: String): String = "$prefix [WARN] $message"

    override fun formatError(message: String): String = "$prefix [ERROR] $message"
}