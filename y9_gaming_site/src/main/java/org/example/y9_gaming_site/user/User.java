package org.example.y9_gaming_site.user;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String salt;

    private int age;

    private boolean isBanned;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean getBanned(){return isBanned;}
    public void setBanned(boolean isBanned){this.isBanned = isBanned;}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

}