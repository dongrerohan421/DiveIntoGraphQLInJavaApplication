package com.springboot.graphql.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springboot.graphql.diveintographqlinjava.pojo.Speaker;
import com.springboot.graphql.diveintographqlinjava.pojo.Talk;
import com.springboot.graphql.diveintographqlinjava.service.SpeakerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TalkResolver implements GraphQLResolver<Talk> {
    private final SpeakerService speakerService;

    public List<Speaker> speakers(Talk talk){
        return speakerService.findAllSpeakersForTalk(talk);
    }
}
