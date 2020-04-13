package pe.creativity.Restfull.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Table(name = "security_user")
@Entity
public class User {

    @GeneratedValue
    @Id
    @Column(name = "id_users", unique = true)
    private Long IdUsers;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String passwd;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public User() {
    }

    public User(String username, String passwd, Role role) {
        this.passwd = passwd;
        this.username = username;
        this.role = Arrays.asList(role);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> role;


    public Long getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(Long idUsers) {
        IdUsers = idUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
