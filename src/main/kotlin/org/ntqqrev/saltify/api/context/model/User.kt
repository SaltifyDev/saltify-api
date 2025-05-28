package org.ntqqrev.saltify.api.context.model

import org.ntqqrev.saltify.api.context.Entity

/**
 * Represents a user in the system.
 */
interface User : Entity {
    /**
     * The ID of the user.
     */
    val uin: Long

    /**
     * Another identifier of the user, if defined.
     */
    val qid: String?

    /**
     * The nickname of the user.
     */
    val nickname: String

    /**
     * The gender of the user.
     */
    val gender: Gender
}