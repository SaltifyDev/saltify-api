package org.ntqqrev.saltify.api.context.event.message

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.api.context.message.MessageScene

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