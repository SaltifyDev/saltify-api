package org.ntqqrev.saltify.api.context.message.outgoing

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Entity

interface MessageSendResult : Entity {
    /**
     * The sequence number of the message that was sent.
     */
    val sequence: Long

    /**
     * The time when the message was sent.
     */
    val time: Instant
}