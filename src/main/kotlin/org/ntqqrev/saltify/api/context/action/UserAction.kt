package org.ntqqrev.saltify.api.context.action

interface UserAction {
    /**
     * Send a poke to a user.
     */
    suspend fun sendPrivatePoke(userUin: Long, isSelf: Boolean): Boolean

    /**
     * Send profile like to a user.
     */
    suspend fun sendProfileLike(userUin: Long, count: Int): Boolean
}