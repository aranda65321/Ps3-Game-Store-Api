package co.com.aranda.ps3.store.crosscuting.persistence.comment.impl;

import co.com.aranda.ps3.store.crosscuting.persistence.comment.entity.Comment;
import co.com.aranda.ps3.store.crosscuting.persistence.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentImpl {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getListComments() {
        return this.commentRepository.findAll();
    }

    public Comment createNewComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return this.createNewComment(comment);
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
