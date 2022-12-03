package ivan.cse.movie.model;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import lombok.Getter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "username")
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;


    @Column(name = "mobile_no")
    private long mobileNo;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name = "password")
    private String password;


    @Column(name = "user_type")
    private String userType;


    public User() {}

    public User(String username, String email, Date dob, long mobileNo, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.mobileNo = mobileNo;
    }
}