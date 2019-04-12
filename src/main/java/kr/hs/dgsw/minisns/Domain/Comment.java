package kr.hs.dgsw.minisns.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private Long userID;
    private String content;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime modifined;

    private String imagePath;
    private String imageOriginalName;

    public Comment(Long userID, String content) {
        this.userID = userID;
        this.content = content;
    }

    public Comment(Long userID, String content, String imagePath, String imageOriginalName) {
        this.userID = userID;
        this.content = content;
        this.imagePath = imagePath;
        this.imageOriginalName = imageOriginalName;
    }

    public Comment(Comment comment) {
        this.id = comment.getId();
        this.userID = comment.getUserID();
        this.content = comment.getContent();
        this.created = comment.getCreated();
        this.modifined = comment.getModifined();
        this.imageOriginalName = comment.getImageOriginalName();
        this.imagePath = comment.getImagePath();
    }

    public void changeCommentData(Comment comment) {
        if (comment == null) return;
        if (comment.content != null) this.content = comment.content;
        if (comment.imagePath != null) this.imagePath = comment.imagePath;
        if (comment.imageOriginalName != null) this.imageOriginalName = comment.imageOriginalName;
    }
}
