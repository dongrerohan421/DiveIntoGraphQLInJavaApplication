package com.springboot.graphql.diveintographqlinjava.service;

import com.springboot.graphql.diveintographqlinjava.pojo.Talk;
import com.springboot.graphql.diveintographqlinjava.repository.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkService {

    @Autowired
    TalkRepository talkRepository;

    public List<Talk> findAll() {
        return talkRepository.findAll();
    }
}
