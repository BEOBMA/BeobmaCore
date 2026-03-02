package org.beobma.beobmaCore.impl

import org.beobma.beobmaCore.api.CoreMessageApi

class CoreMessageApiImpl(
    private val prefix: String,
) : CoreMessageApi {
    override fun formatGlobalMessage(message: String): String = "$prefix $message"
}
