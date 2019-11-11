package com.springboot.graphql.diveintographqlinjava.service;

import com.springboot.graphql.diveintographqlinjava.pojo.Attendee;
import com.springboot.graphql.diveintographqlinjava.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    public List<Attendee> findAll() {
        return attendeeRepository.findAll();
    }
}
