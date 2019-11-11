package com.springboot.graphql.diveintographqlinjava.repository;

import com.springboot.graphql.diveintographqlinjava.pojo.SpeakerTalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerTalkRepository extends JpaRepository<SpeakerTalk, Long> {

    List<SpeakerTalk> findAllBySpeakerId(Long speakerId);

    List<SpeakerTalk> findAllByTalkId(Long talkId);
}
