package com.whereq.llm.mock.common.repository;

import com.whereq.llm.mock.common.vo.Comment;
import reactor.core.publisher.Flux;

public interface CommentRepository {
    Flux<Comment> findAll();
}
