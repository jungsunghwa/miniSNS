package kr.hs.dgsw.minisns.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String email;
    private String password;

    @CreationTimestamp
    private LocalDateTime joined;
    @UpdateTimestamp
    private LocalDateTime modified;

    private String profileImagePath;
    private String profileImageName;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.profileImagePath = "/Users/jungsunghwa/Documents/2019WebPrograming/minisns/upload2019/04/09/user-png-icon-male-user-icon-512.png";
    }

    public void changeUserData(User user){
        if (user == null) return;
        if (user.userName != null) this.userName = user.userName;
        if (user.email != null) this.email = user.email;
        if (user.password != null) this.password = user.password;
        if (user.profileImageName != null) this.profileImageName = user.profileImageName;
        if (user.profileImagePath != null) this.profileImagePath = user.profileImagePath;
    }
}