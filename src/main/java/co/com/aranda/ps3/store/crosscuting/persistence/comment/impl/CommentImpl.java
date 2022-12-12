package co.com.aranda.ps3.store.crosscuting.persistence.comment.impl;

import co.com.aranda.ps3.store.crosscuting.persistence.comment.entity.Comment;
import co.com.aranda.ps3.store.crosscuting.persistence.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommentImpl {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getListComments() {
        return this.commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(long id){
        return this.commentRepository.findById(id);
    }

    public Comment saveComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return this.saveComment(comment);
    }

    public boolean deleteComment(Long id){
        try{
            this.commentRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
