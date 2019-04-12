package kr.hs.dgsw.minisns.Protocol;

import kr.hs.dgsw.minisns.Domain.Comment;
import lombok.Data;


@Data
public class CommentUsernameProtocol extends Comment {
    private String username;

    public CommentUsernameProtocol(Comment c, String username){
        super(c);
        this.username = username;
    }
}
