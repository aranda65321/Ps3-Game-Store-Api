package co.com.aranda.ps3.store.crosscuting.persistence.comment.repository;

import co.com.aranda.ps3.store.crosscuting.persistence.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
