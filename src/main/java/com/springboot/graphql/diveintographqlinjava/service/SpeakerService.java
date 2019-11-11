package com.springboot.graphql.diveintographqlinjava.service;

import com.springboot.graphql.diveintographqlinjava.pojo.Speaker;
import com.springboot.graphql.diveintographqlinjava.pojo.SpeakerTalk;
import com.springboot.graphql.diveintographqlinjava.pojo.Talk;
import com.springboot.graphql.diveintographqlinjava.repository.SpeakerRepository;
import com.springboot.graphql.diveintographqlinjava.repository.SpeakerTalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    @Autowired
    SpeakerRepository speakerRepository;
    @Autowired
    SpeakerTalkRepository speakerTalkRepository;

    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    public List<Speaker> findAllSpeakersForTalk(Talk talk) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllBySpeakerId(talk.getId());
        return st.stream()
                .map(e->speakerRepository.findById(e.getSpeakerId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
