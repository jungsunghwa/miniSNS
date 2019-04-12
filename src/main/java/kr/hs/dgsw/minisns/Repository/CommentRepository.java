package kr.hs.dgsw.minisns.Repository;

import kr.hs.dgsw.minisns.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
