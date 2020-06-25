package pe.creativity.Restfull.entity;

import pe.creativity.Restfull.base.BaseEntity;
import pe.creativity.Restfull.entity.Role;
import pe.creativity.Restfull.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TBL_USER_ROLE")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="SEQ_TBL_USER_ROLE", sequenceName="TBL_USER_ROLE_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQ_TBL_USER_ROLE")
    @Column(name="USER_ROLE_ID", length=10)
    @NotNull
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private pe.creativity.Restfull.entity.User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ROLE_ID")
    private pe.creativity.Restfull.entity.Role role;

    @Column(name = "DESCRIPTION", length=20)
    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public pe.creativity.Restfull.entity.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public pe.creativity.Restfull.entity.Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
