package kr.hs.dgsw.minisns.Service;

import kr.hs.dgsw.minisns.Domain.Comment;
import kr.hs.dgsw.minisns.Domain.User;
import kr.hs.dgsw.minisns.Protocol.AttachmentProtocol;
import kr.hs.dgsw.minisns.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.minisns.Repository.UserRepository;
import kr.hs.dgsw.minisns.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentUsernameProtocol> listAllComments() {
        List<Comment> commentList = this.commentRepository.findAll();
        List<CommentUsernameProtocol> cupList = new ArrayList<>();
        commentList.forEach(comment -> {
            cupList.add(changeCommentToProtocol(comment));
        });
        return cupList;
    }

    @Override
    public CommentUsernameProtocol addComment(Comment comment) {
        comment = this.commentRepository.save(comment);

        return changeCommentToProtocol(comment);
    }

    @Override
    @Transactional
    public CommentUsernameProtocol updateComment(Long id, Comment comment) {
        return this.commentRepository
                .findById(id)
                .map(found -> {
                    found.setUserID(Optional.ofNullable(comment.getUserID()).orElse(found.getUserID()));
                    found.setContent(Optional.ofNullable(comment.getContent()).orElse(found.getContent()));
                    found.setImageOriginalName(Optional.ofNullable(comment.getImageOriginalName()).orElse(found.getImageOriginalName()));
                    found.setImagePath(Optional.ofNullable(comment.getImagePath()).orElse(found.getImagePath()));
                    return changeCommentToProtocol(this.commentRepository.save(found));
                })
                .orElse(null);
    }

    @Override
    public boolean deleteComment(Long id) {
        return this.commentRepository.findById(id).map(found -> {
            this.commentRepository.delete(found);
            return true;
        }).orElse(false);
    }

    @Override
    public AttachmentProtocol getCommentImageByID(Long id) {
        return this.commentRepository
                .findById(id)
                .map(found -> new AttachmentProtocol(
                        found.getImagePath(),
                        found.getImageOriginalName()))
                .orElse(null);
    }

    private CommentUsernameProtocol changeCommentToProtocol(Comment comment){
        Optional<User> found = this.userRepository.findById(comment.getUserID());

        String username = (found.isPresent()) ? found.get().getUserName() : null;

        return new CommentUsernameProtocol(comment, username);
    }

}
