package org.ntqqrev.saltify.api.context.event

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.MessageScene
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.model.GroupMember

abstract class AbstractMessageEvent(
    ctx: Context,
    time: Instant,

    /**
     * The message scene where the message was sent.
     */
    val scene: MessageScene,

    /**
     * The uin of the peer (user uin for private chat, group uin for group chat).
     */
    val peerUin: Long,

    /**
     * The sequence number of the message.
     */
    val sequence: Long,
) : Event(ctx, time)

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

open class MessageRecallEvent(
    ctx: Context,
    time: Instant,
    messageScene: MessageScene,
    peerUin: Long,
    sequence: Long,

    /**
     * The group member who recalled the message if the message was sent in a group.
     */
    val operator: GroupMember?,
) : AbstractMessageEvent(ctx, time, messageScene, peerUin, sequence)