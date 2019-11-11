package com.springboot.graphql.diveintographqlinjava;

import com.coxautodev.graphql.tools.SchemaParser;
import com.springboot.graphql.diveintographqlinjava.resolver.Query;
import com.springboot.graphql.diveintographqlinjava.resolver.TalkResolver;
import com.springboot.graphql.diveintographqlinjava.service.AttendeeService;
import com.springboot.graphql.diveintographqlinjava.service.SpeakerService;
import com.springboot.graphql.diveintographqlinjava.service.TalkService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiveIntoGraphQLInJavaApplication {

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private TalkService talkService;

    @Autowired
    private AttendeeService attendeeService;

    public static void main(String[] args) {
        SpringApplication.run(DiveIntoGraphQLInJavaApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean graphQLServlet() {
        return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(buildSchema(speakerService, attendeeService, talkService)).build(), "/graphql");
    }

    private GraphQLSchema buildSchema(SpeakerService speakerService, AttendeeService attendeeService, TalkService talkService) {
        return SchemaParser
                .newParser()
                .file("graphql/schema.graphqls")
//				.dictionary()
                .resolvers(new Query(speakerService, attendeeService, talkService),
                        new TalkResolver(speakerService))
                .build()
                .makeExecutableSchema();
    }

}
