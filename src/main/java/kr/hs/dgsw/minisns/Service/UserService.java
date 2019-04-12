package kr.hs.dgsw.minisns.Service;



import kr.hs.dgsw.minisns.Domain.User;
import kr.hs.dgsw.minisns.Protocol.AttachmentProtocol;

import java.util.List;

public interface UserService {
    List<User> listAllUser();

    User viewUser();

    User addUser(User user);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);

    AttachmentProtocol getUserImageByID(Long id);

    User loginUser(User user);
}
