package com.whereq.llm.mock.common.web.rest;

import com.whereq.llm.mock.common.repository.CommentRepository;
import com.whereq.llm.mock.common.service.MessageService;
import com.whereq.llm.mock.common.vo.Comment;
import com.whereq.llm.mock.common.vo.Joke;
import com.whereq.llm.mock.common.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController("mockResource")
@RequestMapping("/api/mock")
public class MockResource {

    private final Logger log = LoggerFactory.getLogger(MockResource.class);

    @Autowired
    @Qualifier("jokeFlux")
    private Flux<Joke> jokeFlux;

    @Autowired
    @Qualifier("commentRepository")
    private CommentRepository commentRepository;

    @Autowired
    @Qualifier("messageService")
    private MessageService messageService;

    @GetMapping(path = "/comment/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Comment> commentStream() {
        return this.commentRepository.findAll();
    }

    @GetMapping(path = "/message/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> messageStream() {
        return this.messageService.latestMessages();
    }

    @GetMapping(value = "/joke/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Joke> getJoke() {
        return jokeFlux;
    }
}
