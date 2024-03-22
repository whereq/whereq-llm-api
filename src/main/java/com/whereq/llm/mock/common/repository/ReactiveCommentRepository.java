package com.whereq.llm.mock.common.repository;

import com.whereq.llm.mock.common.utils.CommentGenerator;
import com.whereq.llm.mock.common.vo.Comment;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository("commentRepository")
public class ReactiveCommentRepository implements CommentRepository {

    @Override
    public Flux<Comment> findAll() {
        //simulate data streaming every 1 second.
        return Flux.interval(Duration.ofSeconds(1)).onBackpressureDrop().map(this::generateComment).flatMapIterable(x -> x);
    }

    private List<Comment> generateComment(long interval) {
        Comment obj = new Comment(
            CommentGenerator.randomAuthor(),
            CommentGenerator.randomMessage(),
            CommentGenerator.getCurrentTimeStamp()
        );
        return Arrays.asList(obj);
    }
}
