package com.springboot.graphql.diveintographqlinjava.repository;

import com.springboot.graphql.diveintographqlinjava.pojo.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
}
