package com.sha.serverside.service;

import com.sha.serverside.model.Discussions;
//import com.sha.serverside.model.Comments;
import java.util.List;
import java.util.Optional;

public interface DiscussionService {
    List<Discussions> getAllDiscussions();
    Discussions saveDiscussion(Discussions discussion);

    Discussions findByPostId(Long discId);

    //Comments saveComment(Comments comment);
    //List<Comments> findAllCommentsByDiscussionID(Long discId);
}
