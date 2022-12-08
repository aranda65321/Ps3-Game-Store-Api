package co.com.aranda.ps3.store.crosscuting.domain.traslate;

import co.com.aranda.ps3.store.crosscuting.domain.dto.CommentDto;
import co.com.aranda.ps3.store.crosscuting.domain.pattern.Translator;
import co.com.aranda.ps3.store.crosscuting.persistence.comment.entity.Comment;

public class TranslateComment implements Translator<Comment, CommentDto> {
    @Override
    public Comment translateToEntity(CommentDto input) {
        return Comment.builder()
                .comment(input.getComment())
                .creationDate(input.getCreationDate())
                .build();
    }

    @Override
    public CommentDto translateToDto(Comment input) {
        return CommentDto.builder()
                .comment(input.getComment())
                .creationDate(input.getCreationDate())
                .build();
    }
}
