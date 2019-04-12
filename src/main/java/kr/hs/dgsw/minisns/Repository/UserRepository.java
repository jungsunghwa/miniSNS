package kr.hs.dgsw.minisns.Repository;

import kr.hs.dgsw.minisns.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
