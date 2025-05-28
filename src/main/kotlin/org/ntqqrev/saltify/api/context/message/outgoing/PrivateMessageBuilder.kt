package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity

interface PrivateMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    RecordFeature,
    VideoFeature,
    ReplyFeature,
    ForwardFeature