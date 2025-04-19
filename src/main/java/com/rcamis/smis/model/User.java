package com.rcamis.smis.model;

import com.rcamis.smis.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Constructor
    public User () {}
    public User (String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setName (String name) { this.name = name; }
    public void setEmail (String email) { this.email = email; }
    public void setPassword (String password) { this.password = password; }
    public void setRole (Role role) { this.role = role; }

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public Role getRole () { return this.role; }

}
