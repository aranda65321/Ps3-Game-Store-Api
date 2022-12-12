package co.com.aranda.ps3.store.modules.comment.provider;

import co.com.aranda.ps3.store.crosscuting.domain.dto.CommentDto;
import co.com.aranda.ps3.store.crosscuting.domain.traslate.TranslateComment;
import co.com.aranda.ps3.store.crosscuting.persistence.comment.entity.Comment;
import co.com.aranda.ps3.store.crosscuting.persistence.comment.impl.CommentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Component
public class CommentProvider {
    @Autowired
    private CommentImpl commentImpl;

    @Autowired
    private TranslateComment commentTranslate;

    public List<Comment> getListComments() {
        return this.commentImpl.getListComments();
    }

    public Optional<CommentDto> getCommentById(Long id) {
        Optional<Comment> comment = this.commentImpl.getCommentById(id);
        if (comment.isPresent()) {
            return Optional.of(this.commentTranslate.translateToDto(comment.get()));
        }
        return Optional.empty();
    }

    public Optional<CommentDto> saveComment(CommentDto commentDto) {
        Comment comment = Comment.builder()
                .comment(commentDto.getComment())
                .creationDate(new Date())
                .build();
        return Optional.of(
                this.commentTranslate.translateToDto(this.commentImpl.saveComment(
                        comment
                )));
    }

    public Optional<CommentDto> updateComment(CommentDto commentDto) {
        return Optional.of(
                this.commentTranslate.translateToDto(
                        this.commentImpl.updateComment(
                                this.commentTranslate.translateToEntity(commentDto))));

    }

    public boolean deleteComment(long id) {
        try {
            this.commentImpl.deleteComment(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
