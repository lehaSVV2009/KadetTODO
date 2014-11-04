package com.kadet.kadetTODO.persistence.entity.user;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date lastLoggedIn;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL})
    private Role role;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Date getLastLoggedIn () {
        return lastLoggedIn;
    }

    public void setLastLoggedIn (Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Role getRole () {
        return role;
    }

    public void setRole (Role role) {
        this.role = role;
    }
}
