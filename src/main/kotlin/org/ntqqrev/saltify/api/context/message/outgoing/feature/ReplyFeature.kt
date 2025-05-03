package org.ntqqrev.saltify.api.context.message.outgoing.feature

interface ReplyFeature {
    /**
     * Reply to a message.
     */
    fun reply(messageId: String)
}