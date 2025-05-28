package org.ntqqrev.saltify.api.context.action

interface RequestAction {
    /**
     * Accept the request with the given id.
     */
    suspend fun acceptRequest(requestId: String)

    /**
     * Reject the request with the given id, using the given reason or no reason.
     */
    suspend fun rejectRequest(requestId: String, reason: String? = null)
}