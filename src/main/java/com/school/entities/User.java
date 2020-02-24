package com.school.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String token;
    @NotNull
    private Boolean enabled;
    @ManyToOne
    private Role role;
    @Transient
    private List<Role> roles = new ArrayList();
    @Transient
    private String beautifyRoleName;

    public User() {
    }

    public User(String username, String password, String firstname, String lastname, String email, Boolean enabled, Role role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.enabled = enabled;
        this.role = role;
    }

    public User(String username, String password, String firstname, String lastname, String email, Boolean enabled, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }

    public User(String username, String password, Boolean enabled, Role role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        roles.clear();
        roles.add(role);
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getBeautifyRoleName() {
        if (role == null) {
            return beautifyRoleName;
        }
        if (role.getName() == RoleName.ROLE_ADMIN) {
            beautifyRoleName = "Admin";
        } else if (role.getName() == RoleName.ROLE_USER) {
            beautifyRoleName = "User";
        } else if (role.getName() == RoleName.ROLE_PROFESSOR) {
            beautifyRoleName = "Professor";
        } else if (role.getName() == RoleName.ROLE_STUDENT) {
            beautifyRoleName = "Student";
        } else {
            beautifyRoleName = "Parent";
        }
        return beautifyRoleName;
    }

    public void setBeautifyRoleName(String beautifyRoleName) {
        this.beautifyRoleName = beautifyRoleName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

