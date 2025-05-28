package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity

interface GroupMessageBuilder :
    Entity,
    TextFeature,
    MentionFeature,
    FaceFeature,
    ImageFeature,
    RecordFeature,
    VideoFeature,
    ReplyFeature,
    ForwardFeature