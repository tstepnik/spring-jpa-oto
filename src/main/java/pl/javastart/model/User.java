package pl.javastart.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Column(nullable = false, unique=true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique=true)
    private String email;
    @OneToOne
    @JoinColumn(name = "id_details")
    private UserDetails details;

    public User() {}
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UserDetails getDetails() {
        return details;
    }
    public void setDetails(UserDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", "
                + "password=" + password + ", email=" + email
                + ", details=" + details + "]";
    }
}
