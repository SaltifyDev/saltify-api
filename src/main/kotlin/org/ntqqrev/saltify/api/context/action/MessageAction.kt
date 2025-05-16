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
     * Get some history messages from a user.
     * @param userUin The UIN of the user.
     * @param beginSequence The sequence number of the first message to retrieve (inclusive).
     * @param endSequence The sequence number of the last message to retrieve (exclusive).
     */
    suspend fun queryPrivateMessage(userUin: Long, beginSequence: Long, endSequence: Long): List<PrivateIncomingMessage>

    /**
     * Get some history messages from a group.
     * @param groupUin The UIN of the group.
     * @param beginSequence The sequence number of the first message to retrieve (inclusive).
     * @param endSequence The sequence number of the last message to retrieve (exclusive).
     */
    suspend fun queryGroupMessage(groupUin: Long, beginSequence: Long, endSequence: Long): List<GroupIncomingMessage>

    /**
     * Get a URL for a resource.
     */
    suspend fun getResourceTempUrl(resourceId: String): String

    /**
     * Get the forward messages from ID.
     */
    suspend fun getForwardedMessages(forwardId: String): List<ForwardedIncomingMessage>

    /**
     * Recall a message.
     * @return true if the message was recalled successfully, false otherwise.
     */
    suspend fun recallMessage(incomingMessage: IncomingMessage): Boolean
}