package com.springboot.graphql.diveintographqlinjava.service;

import com.springboot.graphql.diveintographqlinjava.pojo.Speaker;
import com.springboot.graphql.diveintographqlinjava.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    @Autowired
    SpeakerRepository speakerRepository;

    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }
}
