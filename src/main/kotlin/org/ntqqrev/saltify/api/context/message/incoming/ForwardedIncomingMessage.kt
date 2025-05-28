package org.ntqqrev.saltify.api.context.message.incoming

import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment

interface ForwardedIncomingMessage : Entity {
    /**
     * The sender of the original message. Can be fake.
     */
    val senderUin: Long

    /**
     * The sender's nickname in the original message.
     */
    val senderName: String

    /**
     * The content of the message.
     */
    val segments: List<Segment>
}