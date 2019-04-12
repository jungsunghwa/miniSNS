package kr.hs.dgsw.minisns.Service;

import kr.hs.dgsw.minisns.Domain.User;
import kr.hs.dgsw.minisns.Protocol.AttachmentProtocol;
import kr.hs.dgsw.minisns.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User viewUser() {
        return this.userRepository.findAll().get(0);
    }

    @Override
    public User addUser(User user) {
        return (User) this.userRepository.findByEmail(user.getEmail()).map(found -> null).orElse(this.userRepository.save(user));
    }

    /**
     * jpa 영속성 컨텍스트
     *
     */
    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        return this.userRepository
                .findById(id)
                .map(found -> {
                    found.changeUserData(user);
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteUser(Long id) {
        return this.userRepository.findById(id).map(found -> {
            this.userRepository.delete(found);
            return true;
        }).orElse(false);
    }

    @Override
    public User loginUser(User user) {
        return this.userRepository
                .findByEmail(user.getEmail()).filter(found -> found.getPassword().equals(user.getPassword())).orElse(null);
    }

    @Override
    public AttachmentProtocol getUserImageByID(Long id) {
        return this.userRepository
                .findById(id)
                .map(found -> new AttachmentProtocol(
                        found.getProfileImagePath(),
                        found.getProfileImageName()))
                .orElse(null);

    }

}
