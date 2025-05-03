package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class ReplySegment(
    message: IncomingMessage,

    /**
     * The ID of the message being replied to.
     */
    val repliedMessageId: String,
) : Segment(message)