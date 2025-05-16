package org.ntqqrev.saltify.api.context.message.incoming

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment

interface IncomingMessage : Entity {
    /**
     * The sequence number of the message.
     */
    val sequence: Long

    /**
     * The time when the message was sent.
     */
    val time: Instant

    /**
     * The content of the message.
     */
    val segments: List<Segment>
}