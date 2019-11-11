package com.springboot.graphql.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springboot.graphql.diveintographqlinjava.pojo.Attendee;
import com.springboot.graphql.diveintographqlinjava.pojo.Speaker;
import com.springboot.graphql.diveintographqlinjava.pojo.Talk;
import com.springboot.graphql.diveintographqlinjava.service.AttendeeService;
import com.springboot.graphql.diveintographqlinjava.service.SpeakerService;
import com.springboot.graphql.diveintographqlinjava.service.TalkService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final SpeakerService speakerService;
    private final AttendeeService attendeeService;
    private final TalkService talkService;

    public List<Talk> allTalks(){
        return talkService.findAll();
    }

    public List<Speaker> allSpeakers(){
        return speakerService.findAll();
    }

    public List<Attendee> allAttendees(){
        return attendeeService.findAll();
    }
}
