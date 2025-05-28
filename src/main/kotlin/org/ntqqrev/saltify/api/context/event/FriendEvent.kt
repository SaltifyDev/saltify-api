package org.ntqqrev.saltify.api.context.event

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Friend

abstract class AbstractFriendEvent(
    ctx: Context,
    time: Instant,

    /**
     * The friend related to the event.
     */
    val friend: Friend
) : Event(ctx, time)

open class FriendPokeEvent(
    ctx: Context,
    time: Instant,
    friend: Friend,

    /**
     * Whether the poke is sent by the bot itself.
     */
    val isSelfSend: Boolean,

    /**
     * Whether the poke is received by the bot itself.
     */
    val isSelfReceive: Boolean,
) : AbstractFriendEvent(ctx, time, friend)