package kr.hs.dgsw.minisns.Controller;

import kr.hs.dgsw.minisns.Domain.Comment;
import kr.hs.dgsw.minisns.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.minisns.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list/comment")
    public List<CommentUsernameProtocol> list(){
        return this.commentService.listAllComments();
    }

    @PostMapping("/add/comment")
    public CommentUsernameProtocol addComment(@RequestBody Comment comment){
        return this.commentService.addComment(comment);
    }

    @PutMapping("/update/comment/{id}")
    public CommentUsernameProtocol updateComment(@PathVariable Long id, @RequestBody Comment comment){
        return this.commentService.updateComment(id,comment);
    }

    @DeleteMapping("delete/comment/{id}")
    public boolean deleteComment(@PathVariable Long id){
        return this.commentService.deleteComment(id);
    }

}
