package kr.hs.dgsw.minisns.Service;


import kr.hs.dgsw.minisns.Domain.Comment;
import kr.hs.dgsw.minisns.Protocol.AttachmentProtocol;
import kr.hs.dgsw.minisns.Protocol.CommentUsernameProtocol;

import java.util.List;

public interface CommentService {
    List<CommentUsernameProtocol> listAllComments();
    CommentUsernameProtocol addComment(Comment comment);
    CommentUsernameProtocol updateComment(Long id, Comment comment);
    boolean deleteComment(Long id);

    AttachmentProtocol getCommentImageByID(Long id);
}
