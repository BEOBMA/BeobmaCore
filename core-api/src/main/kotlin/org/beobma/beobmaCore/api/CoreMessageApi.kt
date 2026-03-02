package org.beobma.beobmaCore.api

/**
 * 플러그인 전반에서 공통으로 사용할 수 있는 메시지 API.
 * - 일관된 접두사/레벨 포맷
 * - 플레이스홀더 치환
 */
interface CoreMessageApi {
    fun formatGlobalMessage(message: String): String

    fun formatInfo(message: String): String

    fun formatWarn(message: String): String

    fun formatError(message: String): String

    /**
     * message 내 {key} 형태 플레이스홀더를 values의 값으로 치환한다.
     * 예) applyPlaceholders("Hello {user}", mapOf("user" to "beobma"))
     */
    fun applyPlaceholders(message: String, values: Map<String, String>): String
}
