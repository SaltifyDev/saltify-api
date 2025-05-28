package org.ntqqrev.saltify.api.context.action

import org.ntqqrev.saltify.api.context.message.MessageScene
import org.ntqqrev.saltify.api.context.message.incoming.ForwardedIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.context.message.outgoing.MessageSendResult
import org.ntqqrev.saltify.api.context.message.outgoing.PrivateMessageBuilder

interface MessageAction {
    /**
     * Send a private message to a user.
     */
    suspend fun sendPrivateMessage(userUin: Long, builder: PrivateMessageBuilder.() -> Unit): MessageSendResult

    /**
     * Send a group message to a group.
     */
    suspend fun sendGroupMessage(groupUin: Long, builder: GroupMessageBuilder.() -> Unit): MessageSendResult

    /**
     * Get a message by its sequence number.
     */
    suspend fun getMessage(messageScene: MessageScene, peerId: Long, sequence: Long): IncomingMessage?

    /**
     * Get history messages with a starting sequence number and a limit.
     */
    suspend fun getHistoryMessages(
        messageScene: MessageScene,
        peerId: Long,
        startSequence: Long? = null,
        isBackward: Boolean = true,
        limit: Int = 20
    ): List<IncomingMessage>

    /**
     * Get a URL for a resource.
     */
    suspend fun getResourceTempUrl(resourceId: String): String

    /**
     * Get the forward messages from ID.
     */
    suspend fun getForwardedMessages(forwardId: String): List<ForwardedIncomingMessage>

    /**
     * Recall a private message.
     * @return true if the message was recalled successfully, false otherwise.
     */
    suspend fun recallPrivateMessage(userUin: Long, sequence: Long, clientSequence: Long): Boolean

    /**
     * Recall a group message.
     * @return true if the message was recalled successfully, false otherwise.
     */
    suspend fun recallGroupMessage(groupUin: Long, sequence: Long): Boolean
}