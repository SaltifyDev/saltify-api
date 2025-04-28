package org.ntqqrev.saltify.api.context.event.group

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import kotlinx.datetime.Instant

open class GroupEssenceMessageChangeEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The ID of the message that changed.
     */
    val messageId: String,

    /**
     * The group member who set or removed the essence.
     */
    val operator: GroupMember,

    /**
     * Whether the message is set as essence (true) or removed from essence (false).
     */
    val isEssence: Boolean,
) : AbstractGroupEvent(ctx, time, group)