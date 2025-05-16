package org.ntqqrev.saltify.api.context.event.message

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.MessageScene
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage

open class MessageReceiveEvent(
    ctx: Context,

    /**
     * The message that was received.
     */
    val message: IncomingMessage
) : AbstractMessageEvent(
    ctx,
    message.time,
    when (message) {
        is PrivateIncomingMessage -> MessageScene.FRIEND
        is GroupIncomingMessage -> MessageScene.GROUP
        else -> throw IllegalArgumentException("Unknown message type: ${message::class}")
    },
    when (message) {
        is PrivateIncomingMessage -> message.peer.uin
        is GroupIncomingMessage -> message.group.uin
        else -> throw IllegalArgumentException("Unknown message type: ${message::class}")
    },
    message.sequence
)