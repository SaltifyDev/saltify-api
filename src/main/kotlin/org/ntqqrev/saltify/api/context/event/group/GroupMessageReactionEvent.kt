package org.ntqqrev.saltify.api.context.event.group

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember

open class GroupMessageReactionEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The sequence number of the message where the reaction was sent.
     */
    val sequence: Long,

    /**
     * The group member who sent the reaction.
     */
    val sender: GroupMember,

    /**
     * The ID of the reaction.
     */
    val reactionId: String,

    /**
     * Whether the reaction was added or removed.
     */
    val isAdd: Boolean,
) : AbstractGroupEvent(ctx, time, group)