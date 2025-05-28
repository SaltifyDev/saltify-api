package org.ntqqrev.saltify.api.context.event

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context

abstract class AbstractRequestEvent(
    ctx: Context,
    time: Instant,

    /**
     * The id of the request.
     * Can be used to handle the request.
     */
    val requestId: String,

    /**
     * The uin of the operator who sent the request.
     */
    val operatorUin: Long,
) : Event(ctx, time)

abstract class GroupRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,

    /**
     * The uin of the group related to the request.
     */
    val groupUin: Long
) : AbstractRequestEvent(ctx, time, flag, operatorUin)

/**
 * Someone wants to add you as a friend.
 */
open class FriendRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,

    /**
     * The additional message sent with the request.
     */
    val comment: String,

    /**
     * How the requestor found you, e.g., via a group, a friend, or a search.
     */
    val via: String,
) : AbstractRequestEvent(ctx, time, flag, operatorUin)

/**
 * Someone invited you to join the group.
 */
open class GroupInvitationRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,
    groupUin: Long
) : GroupRequestEvent(ctx, time, flag, operatorUin, groupUin)

/**
 * Someone in a group invited another user to join the group
 */
open class GroupInvitedJoinRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,
    groupUin: Long,

    /**
     * The uin of the one being invited to join the group.
     */
    val inviteeUin: Long
) : GroupRequestEvent(ctx, time, flag, operatorUin, groupUin)

/**
 * Someone requests to join the group.
 */
open class GroupJoinRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,
    groupUin: Long,

    /**
     * Whether the request is filtered (regarded as unsafe).
     */
    val isFiltered: Boolean,

    /**
     * The additional message sent with the request.
     */
    val comment: String,
) : GroupRequestEvent(ctx, time, flag, operatorUin, groupUin)