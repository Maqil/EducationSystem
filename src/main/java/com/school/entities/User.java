package com.school.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    //    @JsonIgnore
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String token;
    //    @NotNull
    private Boolean enabled;
    @ManyToOne
    private Role role;
    @Transient
    private List<Role> roles = new ArrayList();
    @Transient
    private String beautifyRoleName;

    public User() {
        this.role = new Role(RoleName.ROLE_STUDENT);
    }

    public User(String firstname, String lastname, String email, String phone, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = new Role(RoleName.ROLE_STUDENT);
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

    public User(String username, String email, String password, Boolean enabled, Role role) {
        this.username = username;
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        } else if (role.getName() == RoleName.ROLE_PARENT) {
            beautifyRoleName = "Parent";
        } else {
            beautifyRoleName = "Student";
        }
        return beautifyRoleName;
    }

    public void setBeautifyRoleName(String beautifyRoleName) {
        this.beautifyRoleName = beautifyRoleName;
    }

}

