package org.beobma.beobmaCore.api.log

interface CoreLogApi {
    fun formatGlobalMessage(message: String): String

    fun formatInfo(message: String): String

    fun formatWarn(message: String): String

    fun formatError(message: String): String
}