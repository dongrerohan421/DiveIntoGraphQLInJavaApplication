package com.springboot.graphql.diveintographqlinjava.repository;

import com.springboot.graphql.diveintographqlinjava.pojo.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
