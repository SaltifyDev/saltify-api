package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity

interface ForwardMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    VideoFeature,
    ReplyFeature,
    ForwardFeature